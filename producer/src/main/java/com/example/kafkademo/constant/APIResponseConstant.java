package com.example.kafkademo.constant;

import static com.example.kafkademo.constant.ExceptionConstant.UTILITY_CLASS_INSTANTIATION_MESSAGE;

public final class APIResponseConstant {
    public static final String PERSON_DETAILS_SENT_MESSAGE = "Person's details sent successfully!";
    public static final String ORDER_SENT_MESSAGE = "Order sent successfully!";

    private APIResponseConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
