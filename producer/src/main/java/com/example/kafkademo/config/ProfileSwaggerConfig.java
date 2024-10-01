package com.example.kafkademo.config;

import com.example.kafkademo.model.Person;
import com.example.kafkademo.model.generated.PersonAvro;
import com.example.kafkademo.util.APIResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import static com.example.kafkademo.constant.ProfileSwaggerConstant.PERSON_DETAILS_SENT_RESPONSE_DESCRIPTION;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.PERSON_DETAILS_SENT_RESPONSE_EXAMPLE;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.SEND_PROFILE_ASYNC_JSON_DESCRIPTION;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.SEND_PROFILE_ASYNC_JSON_REQUEST_BODY_DESCRIPTION;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.SEND_PROFILE_ASYNC_JSON_REQUEST_BODY_EXAMPLE;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.SEND_PROFILE_ASYNC_JSON_RESPONSE_DESCRIPTION;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.SEND_PROFILE_ASYNC_JSON_SUMMARY;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.SEND_PROFILE_SYNC_AVRO_DESCRIPTION;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.SEND_PROFILE_SYNC_AVRO_REQUEST_BODY_DESCRIPTION;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.SEND_PROFILE_SYNC_AVRO_REQUEST_BODY_EXAMPLE;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.SEND_PROFILE_SYNC_AVRO_RESPONSE_DESCRIPTION;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.SEND_PROFILE_SYNC_AVRO_SUMMARY;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.SEND_PROFILE_SYNC_JSON_DESCRIPTION;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.SEND_PROFILE_SYNC_JSON_REQUEST_BODY_DESCRIPTION;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.SEND_PROFILE_SYNC_JSON_REQUEST_BODY_EXAMPLE;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.SEND_PROFILE_SYNC_JSON_RESPONSE_DESCRIPTION;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.SEND_PROFILE_SYNC_JSON_SUMMARY;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SuppressWarnings("checkstyle:MissingJavadocMethod")
public interface ProfileSwaggerConfig {

    @Operation(
            summary = SEND_PROFILE_SYNC_JSON_SUMMARY,
            description = SEND_PROFILE_SYNC_JSON_DESCRIPTION,
            requestBody = @RequestBody(
                    required = true,
                    description = SEND_PROFILE_SYNC_JSON_REQUEST_BODY_DESCRIPTION,
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Person.class),
                            examples = @ExampleObject(value = SEND_PROFILE_SYNC_JSON_REQUEST_BODY_EXAMPLE)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = PERSON_DETAILS_SENT_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = APIResponse.class),
                                    examples = @ExampleObject(value = PERSON_DETAILS_SENT_RESPONSE_EXAMPLE)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = SEND_PROFILE_SYNC_JSON_RESPONSE_DESCRIPTION
                    )
            }
    )
    APIResponse<String> sendProfileDetailsSync(Person person) throws InterruptedException;

    @Operation(
            summary = SEND_PROFILE_SYNC_AVRO_SUMMARY,
            description = SEND_PROFILE_SYNC_AVRO_DESCRIPTION,
            requestBody = @RequestBody(
                    required = true,
                    description = SEND_PROFILE_SYNC_AVRO_REQUEST_BODY_DESCRIPTION,
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = PersonAvro.class),
                            examples = @ExampleObject(value = SEND_PROFILE_SYNC_AVRO_REQUEST_BODY_EXAMPLE)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = PERSON_DETAILS_SENT_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = APIResponse.class),
                                    examples = @ExampleObject(value = PERSON_DETAILS_SENT_RESPONSE_EXAMPLE)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = SEND_PROFILE_SYNC_AVRO_RESPONSE_DESCRIPTION
                    )
            }
    )
    APIResponse<String> sendProfileDetailsAvroSync(PersonAvro person) throws InterruptedException;

    @Operation(
            summary = SEND_PROFILE_ASYNC_JSON_SUMMARY,
            description = SEND_PROFILE_ASYNC_JSON_DESCRIPTION,
            requestBody = @RequestBody(
                    required = true,
                    description = SEND_PROFILE_ASYNC_JSON_REQUEST_BODY_DESCRIPTION,
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Person.class),
                            examples = @ExampleObject(value = SEND_PROFILE_ASYNC_JSON_REQUEST_BODY_EXAMPLE)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = PERSON_DETAILS_SENT_RESPONSE_DESCRIPTION,
                            content = @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = APIResponse.class),
                                    examples = @ExampleObject(value = PERSON_DETAILS_SENT_RESPONSE_EXAMPLE)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = SEND_PROFILE_ASYNC_JSON_RESPONSE_DESCRIPTION
                    )
            }
    )
    APIResponse<String> sendProfileDetailsAsync(Person person);
}

