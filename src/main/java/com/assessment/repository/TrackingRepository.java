package com.assessment.repository;


import com.assessment.entity.TrackingNumber;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingRepository extends MongoRepository<TrackingNumber, String> {

    boolean existsByTrackingNumber(String trackingNumber);

}
