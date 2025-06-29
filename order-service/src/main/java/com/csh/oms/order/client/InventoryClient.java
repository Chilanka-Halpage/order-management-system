package com.csh.oms.order.client;

import com.csh.oms.order.common.ActionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "InventoryClient", url = "http://localhost:8082/")
public interface InventoryClient {
    @GetMapping(value = "api/inventory")
    ActionResponse<Boolean> isInStock(@RequestParam String code, @RequestParam int quantity);
}
