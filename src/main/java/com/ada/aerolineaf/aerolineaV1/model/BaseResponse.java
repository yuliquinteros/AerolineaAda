package com.ada.aerolineaf.aerolineaV1.model;


public class BaseResponse {
    private Base base;
    private String message;

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
