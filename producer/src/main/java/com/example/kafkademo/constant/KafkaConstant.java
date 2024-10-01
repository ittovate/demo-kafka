package com.example.kafkademo.constant;

import static com.example.kafkademo.constant.ExceptionConstant.UTILITY_CLASS_INSTANTIATION_MESSAGE;

public final class KafkaConstant {
    public static final String DEMO_TOPIC = "demo-topic";
    public static final String PERSON_TOPIC = "person-topic";
    public static final String STRING_TOPIC = "string-topic";
    public static final String JSON_TOPIC = "json-topic";

    public static final int PARTITION_COUNT = 1;
    public static final int REPLICATION_COUNT = 1;

    private KafkaConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
