package com.example.kafkademo.config;

import com.example.kafkademo.model.generated.Order;
import com.example.kafkademo.util.APIResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import static com.example.kafkademo.constant.HTTPConstant.OK;
import static com.example.kafkademo.constant.OrderSwaggerConstant.MAKE_ORDER_ASYNC_STRING_DESCRIPTION;
import static com.example.kafkademo.constant.OrderSwaggerConstant.MAKE_ORDER_ASYNC_STRING_SUMMARY;
import static com.example.kafkademo.constant.OrderSwaggerConstant.MAKE_ORDER_SYNC_AVRO_DESCRIPTION;
import static com.example.kafkademo.constant.OrderSwaggerConstant.MAKE_ORDER_SYNC_AVRO_REQUEST_BODY_DESCRIPTION;
import static com.example.kafkademo.constant.OrderSwaggerConstant.MAKE_ORDER_SYNC_AVRO_REQUEST_BODY_EXAMPLE;
import static com.example.kafkademo.constant.OrderSwaggerConstant.MAKE_ORDER_SYNC_AVRO_SUMMARY;
import static com.example.kafkademo.constant.OrderSwaggerConstant.MAKE_ORDER_SYNC_STRING_DESCRIPTION;
import static com.example.kafkademo.constant.OrderSwaggerConstant.MAKE_ORDER_SYNC_STRING_SUMMARY;
import static com.example.kafkademo.constant.OrderSwaggerConstant.ORDER_SENT_RESPONSE_DESCRIPTION;
import static com.example.kafkademo.constant.OrderSwaggerConstant.ORDER_SENT_RESPONSE_EXAMPLE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SuppressWarnings("checkstyle:MissingJavadocMethod")
public interface OrderSwaggerConfig {
    @Operation(
            summary = MAKE_ORDER_SYNC_AVRO_SUMMARY,
            description = MAKE_ORDER_SYNC_AVRO_DESCRIPTION,
            requestBody = @RequestBody(
                    required = true,
                    description = MAKE_ORDER_SYNC_AVRO_REQUEST_BODY_DESCRIPTION,
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Order.class),
                            examples = @ExampleObject(value = MAKE_ORDER_SYNC_AVRO_REQUEST_BODY_EXAMPLE)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = OK,
                            description = ORDER_SENT_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = APIResponse.class),
                                    examples = @ExampleObject(value = ORDER_SENT_RESPONSE_EXAMPLE)
                            )
                    )
            }
    )
    APIResponse<String> makeOrderSync(Order order) throws InterruptedException;

    @Operation(
            summary = MAKE_ORDER_SYNC_STRING_SUMMARY,
            description = MAKE_ORDER_SYNC_STRING_DESCRIPTION,
            responses = {
                    @ApiResponse(
                            responseCode = OK,
                            description = ORDER_SENT_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = APIResponse.class),
                                    examples = @ExampleObject(value = ORDER_SENT_RESPONSE_EXAMPLE)
                            )
                    )
            }
    )
    APIResponse<String> makeOrderSync(String customerEmail) throws InterruptedException;

    @Operation(
            summary = MAKE_ORDER_ASYNC_STRING_SUMMARY,
            description = MAKE_ORDER_ASYNC_STRING_DESCRIPTION,
            responses = {
                    @ApiResponse(
                            responseCode = OK,
                            description = ORDER_SENT_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = APIResponse.class),
                                    examples = @ExampleObject(value = ORDER_SENT_RESPONSE_EXAMPLE)
                            )
                    )
            }
    )
    APIResponse<String> makeOrderAsync(String customerEmail);
}
