package com.example.kafkademo.service;

/**
 * The interface Kafka message service async.
 */
@FunctionalInterface
public interface KafkaMessageServiceAsync {
    /**
     * Send kafka event async.
     *
     * @param value the value
     */
    void sendKafkaEventAsync(Object value);
}
