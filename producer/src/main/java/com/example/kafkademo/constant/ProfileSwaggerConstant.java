package com.example.kafkademo.constant;

import static com.example.kafkademo.constant.ExceptionConstant.UTILITY_CLASS_INSTANTIATION_MESSAGE;

public final class ProfileSwaggerConstant {
    public static final String CONTROLLER_NAME = "Order Controller";
    public static final String CONTROLLER_DESCRIPTION = "Send OTP and verify token";

    //=========================================== Send Profile Sync (JSON) ===========================================//
    public static final String SEND_PROFILE_SYNC_JSON_SUMMARY =
            "Synchronously send profile details in JSON format";
    public static final String SEND_PROFILE_SYNC_JSON_DESCRIPTION =
            "Sends a profile in JSON format synchronously via Kafka to be processed. "
                    + "This request will wait for acknowledgment.";
    public static final String SEND_PROFILE_SYNC_JSON_REQUEST_BODY_DESCRIPTION =
            "Profile details must be valid and include all required fields.";
    public static final String SEND_PROFILE_SYNC_JSON_REQUEST_BODY_EXAMPLE = """
            {
              "name": "John Doe",
              "age": 30,
              "email": "johndoe@example.com"
            }
            """;
    public static final String PERSON_DETAILS_SENT_RESPONSE_DESCRIPTION =
            "When the profile details are successfully sent.";
    public static final String PERSON_DETAILS_SENT_RESPONSE_EXAMPLE = """
            {
                "statusCode": 200,
                "message": "Profile details sent successfully!",
                "timestamp": "2024-09-27T17:17:58.6897236",
                "body": null
            }
            """;
    public static final String SEND_PROFILE_SYNC_JSON_RESPONSE_DESCRIPTION =
            "When there is an error in sending the profile details in JSON format.";

    //=========================================== Send Profile Sync (Avro) ===========================================//
    public static final String SEND_PROFILE_SYNC_AVRO_SUMMARY =
            "Synchronously send profile details using Avro format";
    public static final String SEND_PROFILE_SYNC_AVRO_DESCRIPTION =
            "Sends a profile in Avro format synchronously via Kafka to be processed."
                    + "This request will wait for acknowledgment.";
    public static final String SEND_PROFILE_SYNC_AVRO_REQUEST_BODY_DESCRIPTION =
            "Profile details must be valid and include all required fields.";
    public static final String SEND_PROFILE_SYNC_AVRO_REQUEST_BODY_EXAMPLE = """
            {
              "name": "Jane Doe",
              "age": 28,
              "email": "janedoe@example.com"
            }
            """;
    public static final String SEND_PROFILE_SYNC_AVRO_RESPONSE_DESCRIPTION =
            "When there is an error in sending the profile details in Avro format.";

    //========================================== Send Profile Async (JSON) ==========================================//
    public static final String SEND_PROFILE_ASYNC_JSON_SUMMARY =
            "Asynchronously send profile details in JSON format";
    public static final String SEND_PROFILE_ASYNC_JSON_DESCRIPTION =
            "Sends a profile in JSON format asynchronously via Kafka to be processed."
                    + "This request does not wait for acknowledgment.";
    public static final String SEND_PROFILE_ASYNC_JSON_REQUEST_BODY_DESCRIPTION =
            "Profile details must be valid and include all required fields.";
    public static final String SEND_PROFILE_ASYNC_JSON_REQUEST_BODY_EXAMPLE = """
            {
              "name": "John Smith",
              "age": 35,
              "email": "johnsmith@example.com"
            }
            """;
    public static final String SEND_PROFILE_ASYNC_JSON_RESPONSE_DESCRIPTION =
            "When there is an error in sending the profile details asynchronously in JSON format.";

    private ProfileSwaggerConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
