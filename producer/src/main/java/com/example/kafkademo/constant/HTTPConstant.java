package com.example.kafkademo.constant;

import static com.example.kafkademo.constant.ExceptionConstant.UTILITY_CLASS_INSTANTIATION_MESSAGE;

public final class HTTPConstant {
    public static final String OK = "200";


    private HTTPConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
