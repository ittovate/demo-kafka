package com.example.kafka_demo.util;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class APIResponse<T> {
    private HttpStatus status;
    private String message;
    private T body;
    public static <T> APIResponse<T> success(T data,String message) {
        return APIResponse.<T>builder()
                .message(message)
                .body(data)
                .status(HttpStatus.OK)
                .build();
    }

    public static <T> APIResponse<T> badRequest(T data,String message) {
        return APIResponse.<T>builder()
                .message(message)
                .body(data)
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }
    public static <T> APIResponse<T> defaultError(T data) {
        return APIResponse.<T>builder()
                .message("Internal Server Error!")
                .body(data)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }

}
