package com.csh.oms.order.client;

import com.csh.oms.order.common.ActionResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface InventoryClient {
    @GetExchange(value = "/api/inventory")
    ActionResponse<Boolean> isInStock(@RequestParam String code, @RequestParam int quantity);
}
