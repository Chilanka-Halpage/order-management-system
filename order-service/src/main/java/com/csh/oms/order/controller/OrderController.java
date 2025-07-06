package com.csh.oms.order.controller;

import com.csh.oms.order.common.ActionResponse;
import com.csh.oms.order.dto.OrderRequestDTO;
import com.csh.oms.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ActionResponse<String>> create(@RequestBody OrderRequestDTO orderRequestDTO) {
        ActionResponse<String> actionResponse = orderService.placeOrder(orderRequestDTO);
        return new ResponseEntity<>(actionResponse, HttpStatus.CREATED);
    }
}
