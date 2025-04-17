package com.haibolian.libsys.common;

public enum ResultCode {
    SUCCESS(200, "操作成功"),

    FAILED(500, "操作失败");

    private final Integer code;
    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }


}
