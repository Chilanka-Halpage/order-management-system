package com.csh.oms.inventory.controller;

import com.csh.oms.inventory.common.ActionResponse;
import com.csh.oms.inventory.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/inventory")
@AllArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ActionResponse<Boolean> isInStock(@RequestParam String code, @RequestParam int quantity) {
        return inventoryService.isInStock(code, quantity);
    }
}
