package com.example.kafkademo.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * The interface Kafka message service sync.
 */
@FunctionalInterface
public interface KafkaMessageServiceSync {
    /**
     * Send kafka event sync.
     *
     * @param value the value
     * @throws ExecutionException   the execution exception
     * @throws InterruptedException the interrupted exception
     * @throws TimeoutException     the timeout exception
     */
    void sendKafkaEventSync(Object value) throws ExecutionException, InterruptedException, TimeoutException;
}
