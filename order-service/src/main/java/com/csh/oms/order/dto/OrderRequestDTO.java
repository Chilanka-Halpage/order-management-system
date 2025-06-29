package com.csh.oms.order.dto;

public record OrderRequestDTO(String orderId, String inventoryCode, String description, int quantity, double price) {
}
