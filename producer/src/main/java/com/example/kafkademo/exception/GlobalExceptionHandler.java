package com.example.kafkademo.exception;

import com.example.kafkademo.util.APIResponse;
import com.example.kafkademo.util.ResponseUtil;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public APIResponse<String> defaultError(Exception exception){
        return ResponseUtil.createUnifiedResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), null);
    }
}
