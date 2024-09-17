package com.example.kafka_demo.controller;

import com.example.kafka_demo.model.Person;
import com.example.kafka_demo.model.generated.PersonAvro;
import com.example.kafka_demo.service.ProfileAvroService;
import com.example.kafka_demo.service.ProfileService;
import com.example.kafka_demo.util.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
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
    public ResponseEntity<APIResponse<String>> sendProfileDetailsSync(@RequestBody Person person){
        profileService.sendPersonDetailsSync(person);
        APIResponse<String> apiResponse = APIResponse.success(null,
                "Person {" + person + "}'s details sent successfully!");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    /**
     * Synchronously sends profile details using Avro.
     *
     * @return ResponseEntity with APIResponse and status
     */
    @PostMapping("/avro/profile/sync")
    public ResponseEntity<APIResponse<String>> sendProfileDetailsAvroSync(@RequestBody PersonAvro person){
        profileAvroService.sendProfileDetailsAvroSync(person);
        APIResponse<String> apiResponse = APIResponse.success(null,
                "Person {" + person + "}'s details sent avro successfully!");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    /**
     * Asynchronously sends profile details in JSON format.
     *
     * @return ResponseEntity with APIResponse and status
     */
    @PostMapping("/async")
    public ResponseEntity<APIResponse<String>> sendProfileDetailsAsync(@RequestBody Person person){
        profileService.sendPersonDetailsAsync(person);
        APIResponse<String> apiResponse = APIResponse.success(null,
                "Person {" + person + "}'s details sent successfully!");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
