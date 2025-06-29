package com.csh.oms.inventory.exception;

import com.csh.oms.inventory.common.ActionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InventoryServiceRuntimeException.class)
    public ResponseEntity<ActionResponse<String>> handleProductRuntimeException(InventoryServiceRuntimeException exception) {
        ActionResponse<String> actionResponse = new ActionResponse<>(false, exception.getStatus().getReasonPhrase(), exception.getMessage());
        return new ResponseEntity<>(actionResponse, exception.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ActionResponse<String>> handleGeneralException(Exception exception) {
        ActionResponse<String> actionResponse = new ActionResponse<>(false, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), exception.getMessage());
        return new ResponseEntity<>(actionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
