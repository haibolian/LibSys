package com.haibolian.libsys.common;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;

    private String message;

    private T data;

    public Result(){}

    public Result(Integer code, String message ){
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success () {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> failed(){
        return new Result<>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage());
    }

    public static <T> Result<T> failed(String message) {
        return new Result<>(ResultCode.FAILED.getCode(), message);
    }

}
