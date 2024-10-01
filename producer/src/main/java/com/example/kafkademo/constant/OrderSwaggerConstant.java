package com.example.kafkademo.constant;

import static com.example.kafkademo.constant.ExceptionConstant.UTILITY_CLASS_INSTANTIATION_MESSAGE;

public final class OrderSwaggerConstant {
    public static final String CONTROLLER_NAME = "Order Controller";
    public static final String CONTROLLER_DESCRIPTION = "Send OTP and verify token";

    //============================================ Make Order Sync (AVRO) ============================================//
    public static final String MAKE_ORDER_SYNC_AVRO_SUMMARY = "Synchronously send order details in AVRO format";
    public static final String MAKE_ORDER_SYNC_AVRO_DESCRIPTION =
            "Sends an order in AVRO format via Kafka to be processed. This request will wait for acknowledgment.";
    public static final String MAKE_ORDER_SYNC_AVRO_REQUEST_BODY_DESCRIPTION =
            "Order details must be valid and include all required fields.";
    public static final String MAKE_ORDER_SYNC_AVRO_REQUEST_BODY_EXAMPLE = """
            {
              "orderId": "12345",
              "customerEmail": "customer@example.com",
              "orderItems": [
                {
                  "itemId": "9876",
                  "quantity": 2
                }
              ]
            }
            """;
    public static final String ORDER_SENT_RESPONSE_DESCRIPTION = "When the order is successfully sent in AVRO format.";
    public static final String ORDER_SENT_RESPONSE_EXAMPLE = """
            {
                "statusCode": 200,
                "message": "Order sent successfully!",
                "timestamp": "2024-09-27T17:17:58.6897236",
                "body": null
            }
            """;

    //=========================================== Make Order Sync (String) ===========================================//
    public static final String MAKE_ORDER_SYNC_STRING_SUMMARY = "Synchronously send profile details in String format";
    public static final String MAKE_ORDER_SYNC_STRING_DESCRIPTION =
            "Sends a customer's email address in String format synchronously via Kafka to be processed. "
                    + "This request will wait for acknowledgment.";
    public static final String MAKE_ORDER_SYNC_STRING_PATH_PARAM_DESCRIPTION =
            "Customer email must be valid and provided in the path.";


    //========================================= Make Order Async (String) ==========================================//
    public static final String MAKE_ORDER_ASYNC_STRING_SUMMARY = "Asynchronously send profile details in String format";
    public static final String MAKE_ORDER_ASYNC_STRING_DESCRIPTION =
            "Sends a customer's email address in String format asynchronously via Kafka to be processed."
                    + "This request does not wait for acknowledgment.";
    public static final String MAKE_ORDER_ASYNC_STRING_PATH_PARAM_DESCRIPTION =
            "Customer email must be valid and provided in the path.";


    private OrderSwaggerConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
