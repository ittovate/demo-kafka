package com.example.kafkademo.service;

@FunctionalInterface
public interface KafkaMessageServiceAsync {
    void sendKafkaEventAsync(Object value);
}
