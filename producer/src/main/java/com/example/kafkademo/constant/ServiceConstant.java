package com.example.kafkademo.constant;

import static com.example.kafkademo.constant.ExceptionConstant.UTILITY_CLASS_INSTANTIATION_MESSAGE;

public final class ServiceConstant {
    public static final int SIMULATING_SLEEP_MS = 2000;

    private ServiceConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
