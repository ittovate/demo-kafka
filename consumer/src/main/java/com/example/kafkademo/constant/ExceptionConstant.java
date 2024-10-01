package com.example.kafkademo.constant;

public final class ExceptionConstant {
    public static final String UTILITY_CLASS_INSTANTIATION_MESSAGE = "Utility class should not be instantiated!";

    private ExceptionConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
