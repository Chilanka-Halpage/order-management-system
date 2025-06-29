package com.csh.oms.inventory.service.impl;

import com.csh.oms.inventory.common.ActionResponse;
import com.csh.oms.inventory.exception.InventoryServiceRuntimeException;
import com.csh.oms.inventory.repository.InventoryRepository;
import com.csh.oms.inventory.service.InventoryService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {
    private final Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);
    private final InventoryRepository inventoryRepository;

    @Override
    public ActionResponse<Boolean> isInStock(String code, int quantity) {
        try {
            boolean isInStock = inventoryRepository.existsByCodeAndQuantityGreaterThanEqual(code, quantity);

            logger.info("{} quantity from {} is{} available", quantity, code, isInStock? "": " not");

            return new ActionResponse<>(isInStock);

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw new InventoryServiceRuntimeException("Inventory check failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
