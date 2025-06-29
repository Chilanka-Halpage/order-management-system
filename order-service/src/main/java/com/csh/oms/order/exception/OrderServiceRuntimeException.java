package com.csh.oms.order.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter()
public class OrderServiceRuntimeException extends RuntimeException {
    private final HttpStatus status;
    public OrderServiceRuntimeException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
