package com.assessment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TrackingNumberPrecomputeService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String TRACKING_NUMBER_CACHE = "tracking_numbers";

    public void generateTrackingNumbers(int count) {
        for (int i = 0; i < count; i++) {
            String trackingNumber = generateUniqueTrackingNumber();
            redisTemplate.opsForList().leftPush(TRACKING_NUMBER_CACHE, trackingNumber);
        }
    }

    private String generateUniqueTrackingNumber() {
        return "DL" + UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 8);
    }
}
