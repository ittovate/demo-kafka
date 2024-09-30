package com.example.kafkademo.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@FunctionalInterface
public interface KafkaMessageServiceSync {
    void sendKafkaEventSync(Object value) throws ExecutionException, InterruptedException, TimeoutException;
}
