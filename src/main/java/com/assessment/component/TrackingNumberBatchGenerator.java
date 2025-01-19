package com.assessment.component;


import com.assessment.service.TrackingNumberPrecomputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TrackingNumberBatchGenerator {

    @Autowired
    private TrackingNumberPrecomputeService precomputeService;

    //@Scheduled(fixedRate = 60000) // Every minute
    public void generateBatch() {
        System.out.println("Generate tracking numbers : " + LocalDateTime.now());
        precomputeService.generateTrackingNumbers(1000); // Generate 100,000 tracking numbers
    }
}
