package com.haibolian.libsys.exception;

import com.haibolian.libsys.common.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handleValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if(bindingResult.hasErrors()) {
            message = bindingResult.getFieldError().getDefaultMessage();
        }
        return Result.failed(message);
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public Result<Object> handleBindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return Result.failed(message);
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e){
        return Result.failed(e.getMessage());
    }
}
