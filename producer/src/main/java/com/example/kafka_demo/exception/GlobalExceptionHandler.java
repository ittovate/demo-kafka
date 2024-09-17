package com.example.kafka_demo.exception;

import com.example.kafka_demo.util.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    public Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<String>> defaultError(Exception exception){
        logger.error(exception.getMessage());
        exception.printStackTrace();
        APIResponse<String> apiResponse = APIResponse.defaultError(exception.getMessage());
        return new ResponseEntity<  >(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
