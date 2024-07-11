package com.example.kafka_demo.controller;

import com.example.kafka_demo.model.Person;
import com.example.kafka_demo.service.ProfileService;
import com.example.kafka_demo.util.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/sync")
    public ResponseEntity<APIResponse<String>> sendProfileDetailsSync(@RequestBody Person person){
        profileService.sendPersonDetailsSync(person);
        APIResponse<String> apiResponse = APIResponse.success(null,
                "Person {" + person + "}'s details sent successfully!");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @PostMapping("/async")
    public ResponseEntity<APIResponse<String>> sendProfileDetailsAsync(@RequestBody Person person){
        profileService.sendPersonDetailsAsync(person);
        APIResponse<String> apiResponse = APIResponse.success(null,
                "Person {" + person + "}'s details sent successfully!");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
