package com.csh.oms.order.service;

import com.csh.oms.order.common.ActionResponse;
import com.csh.oms.order.dto.OrderRequestDTO;

public interface OrderService {
    ActionResponse<String> placeOrder(OrderRequestDTO orderRequestDTO);
}
