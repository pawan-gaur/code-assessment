package com.assessment.controller;

import com.assessment.entity.TrackingNumber;
import com.assessment.entity.dto.TrackingNumberRequest;
import com.assessment.entity.dto.TrackingNumberResponse;
import com.assessment.service.TrackingService;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@Validated
public class TrackingController {

    @Autowired
    private TrackingService service;

    @GetMapping("/next-tracking-number")
    public ResponseEntity<?> generateTrackingNumber(
            @RequestParam(value = "origin_country_id")
            @Pattern(regexp = "^[A-Z]{2}$", message = "Invalid origin country code. Must be ISO 3166-1 alpha-2 format.") String originCountryId,

            @RequestParam(value = "destination_country_id")
            @Pattern(regexp = "^[A-Z]{2}$", message = "Invalid destination country code. Must be ISO 3166-1 alpha-2 format.") String destinationCountryId,

            @RequestParam(value = "weight")
            @DecimalMin(value = "0.001", message = "Weight must be greater than 0.") @Digits(integer = 10, fraction = 3, message = "Weight can have up to three decimal places.") double weight,

            @RequestParam(value = "created_at", required = false) String createdAt,

            @RequestParam(value = "customer_id", required = false) String customerId,

            @RequestParam(value = "customer_name", required = false) String customerName,

            @RequestParam(value = "customer_slug", required = false)
            @Pattern(regexp = "^[a-z0-9]+(-[a-z0-9]+)*$", message = "Customer slug must be in slug-case (e.g., 'redbox-logistics').") String customerSlug) {
        OffsetDateTime parseCreatedAt = null;
        if(createdAt!=null) {
            String normalizedCreatedAt = createdAt.replace(" ", "+");
            parseCreatedAt = OffsetDateTime.parse(normalizedCreatedAt, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }
        
        TrackingNumberRequest request = new TrackingNumberRequest(originCountryId, destinationCountryId, weight, parseCreatedAt,
                customerId, customerName, customerSlug);
        TrackingNumberResponse response = service.createTrackingNumber(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTrackingRecord() {
        List<TrackingNumber> result = service.getAllTrackingRecord();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
