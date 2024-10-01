package com.example.kafkademo.constant;

import static com.example.kafkademo.constant.ExceptionConstant.UTILITY_CLASS_INSTANTIATION_MESSAGE;

public final class SwaggerConstant {
    public static final String TITLE = "OTP Service API";
    public static final String VERSION = "1.0";
    public static final String DESCRIPTION = "API to send OTP in SMS and verify it.";
    public static final String CONTACT_NAME = "ittovate";
    public static final String CONTACT_URL = "https://github.com/orgs/ittovate/";

    private SwaggerConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
