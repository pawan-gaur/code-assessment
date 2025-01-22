package com.assessment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public ResponseEntity<?> home() {
        return new ResponseEntity<>("Welcome to code-assessment app. Assignment to generate tracking number", HttpStatus.OK);
    }

    @GetMapping("/health")
    public ResponseEntity<?> getAllTrackingRecord() {
        return new ResponseEntity<>("Health : OK", HttpStatus.OK);
    }

}
