package com.csh.oms.inventory.repository;

import com.csh.oms.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    boolean existsByCodeAndQuantityGreaterThanEqual(String code, int quantity);
}
