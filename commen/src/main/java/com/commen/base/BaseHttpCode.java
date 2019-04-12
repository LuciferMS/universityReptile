package com.commen.base;

public enum BaseHttpCode {
    /**
     * 成功
     */
    SUCCESS(200),

    FAIL(400);

    Integer code;

    BaseHttpCode(Integer code){
        this.code = code;
    }

    public Integer getCode(){
        return code;
    }
}
