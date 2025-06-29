package com.csh.oms.product_service.exception;

import org.springframework.http.HttpStatus;

public class ProductServiceRuntimeException extends RuntimeException {
    private final HttpStatus status;

    public ProductServiceRuntimeException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
