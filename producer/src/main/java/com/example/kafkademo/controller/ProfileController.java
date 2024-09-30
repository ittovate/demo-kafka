package com.example.kafkademo.controller;

import static com.example.kafkademo.constant.APIResponseConstant.PERSON_DETAILS_SENT_MESSAGE;

import com.example.kafkademo.model.Person;
import com.example.kafkademo.model.generated.PersonAvro;
import com.example.kafkademo.service.ProfileAvroService;
import com.example.kafkademo.service.ProfileService;
import com.example.kafkademo.util.APIResponse;
import com.example.kafkademo.util.ResponseUtil;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/profiles")
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileAvroService profileAvroService ;

    public ProfileController(ProfileService profileService, ProfileAvroService profileAvroService) {
        this.profileService = profileService;
        this.profileAvroService = profileAvroService;
    }

    /**
     * Synchronously sends profile details in JSON format.
     *
     * @return ResponseEntity with APIResponse and status
     */
    @PostMapping("/sync")
    public APIResponse<String> sendProfileDetailsSync(@RequestBody Person person)
            throws InterruptedException {
        profileService.sendPersonDetailsSync(person);
        return ResponseUtil.createUnifiedResponse(HttpStatus.OK.value(),
                PERSON_DETAILS_SENT_MESSAGE,null);
    }


    /**
     * Synchronously sends profile details using Avro.
     *
     * @return ResponseEntity with APIResponse and status
     */
    @PostMapping("/sync/avro")
    public APIResponse<String> sendProfileDetailsAvroSync(@RequestBody PersonAvro person)
            throws InterruptedException {
        profileAvroService.sendProfileDetailsAvroSync(person);
        return ResponseUtil.createUnifiedResponse(HttpStatus.OK.value(),
                PERSON_DETAILS_SENT_MESSAGE,null);
    }

    /**
     * Asynchronously sends profile details in JSON format.
     *
     * @return ResponseEntity with APIResponse and status
     */
    @PostMapping("/async")
    public APIResponse<String> sendProfileDetailsAsync(@RequestBody Person person){
        profileService.sendPersonDetailsAsync(person);
        return ResponseUtil.createUnifiedResponse(HttpStatus.OK.value(),
                PERSON_DETAILS_SENT_MESSAGE,null);
    }

}
