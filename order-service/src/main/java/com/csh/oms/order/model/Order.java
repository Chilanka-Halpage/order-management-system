package com.csh.oms.order.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "orders", schema = "order_service")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder()
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderId;
    private String inventoryCode;
    private String description;
    private int quantity;
    private double price;

}
