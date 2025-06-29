package com.csh.oms.order.service.impl;

import com.csh.oms.order.client.InventoryClient;
import com.csh.oms.order.common.ActionResponse;
import com.csh.oms.order.dto.OrderRequestDTO;
import com.csh.oms.order.exception.OrderServiceRuntimeException;
import com.csh.oms.order.model.Order;
import com.csh.oms.order.repository.OrderServiceRepository;
import com.csh.oms.order.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    private final OrderServiceRepository orderServiceRepository;
    private final InventoryClient inventoryClient;

    @Override
    public ActionResponse<String> placeOrder(OrderRequestDTO orderRequestDTO) {
        try {
            ActionResponse<Boolean> inStock = inventoryClient.isInStock(orderRequestDTO.inventoryCode(), orderRequestDTO.quantity());
            if (inStock.getData()) {
                Order order = Order.builder()
                        .inventoryCode(orderRequestDTO.inventoryCode())
                        .description(orderRequestDTO.description())
                        .quantity(orderRequestDTO.quantity())
                        .price(orderRequestDTO.price()).build();

                orderServiceRepository.save(order);

                logger.info("Order {} Placed Successfully", order.getOrderId());

                return new ActionResponse<>("Order Placed Successfully", order.getOrderId().toString());
            } else {
                logger.error("{} quantity from {} is not available", orderRequestDTO.quantity(), orderRequestDTO.inventoryCode());
                throw new OrderServiceRuntimeException("Not enough quantity in stock", HttpStatus.OK);
            }
        } catch (OrderServiceRuntimeException ex) {
            logger.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new OrderServiceRuntimeException("Order Placing failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
