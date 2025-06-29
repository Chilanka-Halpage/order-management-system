package com.csh.oms.inventory.service;

import com.csh.oms.inventory.common.ActionResponse;

public interface InventoryService {
    ActionResponse<Boolean> isInStock(String code, int quantity);
}
