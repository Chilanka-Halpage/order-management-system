package com.csh.oms.inventory.common;

public class ActionResponse<T> {
    private boolean success = true;
    private String message;
    private T data;

    public ActionResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ActionResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public ActionResponse(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
