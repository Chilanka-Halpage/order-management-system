package com.csh.oms.inventory.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter()
public class InventoryServiceRuntimeException extends RuntimeException {
    private final HttpStatus status;
    public InventoryServiceRuntimeException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
