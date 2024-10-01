package com.example.kafkademo.exception;

import com.example.kafkademo.util.APIResponse;
import com.example.kafkademo.util.APIResponseUtil;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The type Global exception handler.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Default error api response.
     *
     * @param exception the exception
     * @return the api response
     */
    @ExceptionHandler(Exception.class)
    public APIResponse<String> defaultError(Exception exception) {
        return APIResponseUtil.createUnifiedResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), null);
    }
}
