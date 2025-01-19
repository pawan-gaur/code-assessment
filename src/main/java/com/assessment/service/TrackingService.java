package com.assessment.service;

import com.assessment.entity.TrackingNumber;
import com.assessment.entity.dto.TrackingNumberRequest;
import com.assessment.entity.dto.TrackingNumberResponse;
import com.assessment.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TrackingService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private TrackingRepository repository;

    //private static final String TRACKING_NUMBER_CACHE = "tracking_numbers";


    public TrackingNumberResponse createTrackingNumber(TrackingNumberRequest request) {

        /*
         * UnComment below in case Scalable is required Also enable scheduling on Main class
         * /
        /*String trackingNumber = redisTemplate.opsForList().rightPop(TRACKING_NUMBER_CACHE);
        if (trackingNumber == null) {
            throw new RuntimeException("No precomputed tracking numbers available!");
        }*/

        String trackingNumber;
        do {
            trackingNumber = generateTrackingNumber(request.getOriginCountryId(), request.getDestinationCountryId());
        } while (repository.existsByTrackingNumber(trackingNumber));


        TrackingNumber tracking = Mapper.map(request, new TrackingNumber());
        tracking.setTrackingNumber(trackingNumber);
        TrackingNumber result = repository.save(tracking);
        return new TrackingNumberResponse(result.getTrackingNumber(), request.getCreatedAt(), result.getCreatedTimestamp());

    }

    private String generateTrackingNumber(String originCountryId, String destinationCountryId) {
        String uuidPart = UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase();
        return "DL" + originCountryId + destinationCountryId + uuidPart;
    }

    public List<TrackingNumber> getAllTrackingRecord() {
        return repository.findAll();
    }
}
