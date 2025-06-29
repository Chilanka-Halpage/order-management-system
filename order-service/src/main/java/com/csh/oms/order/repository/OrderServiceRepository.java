package com.csh.oms.order.repository;

import com.csh.oms.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderServiceRepository extends JpaRepository<Order, String> {
}
