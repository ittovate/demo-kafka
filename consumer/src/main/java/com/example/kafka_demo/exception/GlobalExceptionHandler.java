package com.example.kafka_demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    public Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    public void defaultError(Exception exception){
        logger.error(exception.getMessage());
    }
}
