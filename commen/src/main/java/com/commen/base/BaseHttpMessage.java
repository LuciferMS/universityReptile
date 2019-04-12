package com.commen.base;

public enum BaseHttpMessage {

    SUCCESS("success"),

    FAIL("fail");

    String message;

    BaseHttpMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
