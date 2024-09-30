package com.example.kafkademo.util;

public record APIResponse<T>(int statusCode, String message,T Body){
}
