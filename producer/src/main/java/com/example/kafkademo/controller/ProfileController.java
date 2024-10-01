package com.example.kafkademo.controller;

import com.example.kafkademo.config.ProfileSwaggerConfig;
import com.example.kafkademo.model.Person;
import com.example.kafkademo.model.generated.PersonAvro;
import com.example.kafkademo.service.ProfileAvroService;
import com.example.kafkademo.service.ProfileService;
import com.example.kafkademo.util.APIResponse;
import com.example.kafkademo.util.APIResponseUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.kafkademo.constant.APIResponseConstant.PERSON_DETAILS_SENT_MESSAGE;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.CONTROLLER_DESCRIPTION;
import static com.example.kafkademo.constant.ProfileSwaggerConstant.CONTROLLER_NAME;

@RestController
@RequestMapping("api/v1/profiles")
@Tag(name = CONTROLLER_NAME, description = CONTROLLER_DESCRIPTION)
public class ProfileController implements ProfileSwaggerConfig {

    private final ProfileService profileService;
    private final ProfileAvroService profileAvroService;

    /**
     * Instantiates a new Profile controller.
     *
     * @param profileService     the profile service
     * @param profileAvroService the profile avro service
     */
    public ProfileController(ProfileService profileService, ProfileAvroService profileAvroService) {
        this.profileService = profileService;
        this.profileAvroService = profileAvroService;
    }

    /**
     * Synchronously sends profile details in JSON format.
     *
     * @param person the person
     * @return ResponseEntity with APIResponse and status
     * @throws InterruptedException the interrupted exception
     */
    @PostMapping("/sync")
    public APIResponse<String> sendProfileDetailsSync(@RequestBody Person person)
            throws InterruptedException {
        profileService.sendPersonDetailsSync(person);
        return APIResponseUtil.createUnifiedResponse(HttpStatus.OK.value(),
                PERSON_DETAILS_SENT_MESSAGE, null);
    }


    /**
     * Synchronously sends profile details using Avro.
     *
     * @param person the person
     * @return ResponseEntity with APIResponse and status
     * @throws InterruptedException the interrupted exception
     */
    @PostMapping("/sync/avro")
    public APIResponse<String> sendProfileDetailsAvroSync(@RequestBody PersonAvro person)
            throws InterruptedException {
        profileAvroService.sendProfileDetailsAvroSync(person);
        return APIResponseUtil.createUnifiedResponse(HttpStatus.OK.value(),
                PERSON_DETAILS_SENT_MESSAGE, null);
    }

    /**
     * Asynchronously sends profile details in JSON format.
     *
     * @param person the person
     * @return ResponseEntity with APIResponse and status
     */
    @PostMapping("/async")
    public APIResponse<String> sendProfileDetailsAsync(@RequestBody Person person) {
        profileService.sendPersonDetailsAsync(person);
        return APIResponseUtil.createUnifiedResponse(HttpStatus.OK.value(),
                PERSON_DETAILS_SENT_MESSAGE, null);
    }
}
