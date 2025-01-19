package com.assessment.service;

import com.assessment.entity.TrackingNumber;
import com.assessment.entity.dto.TrackingNumberRequest;

public class Mapper {

    public static TrackingNumber map(TrackingNumberRequest req, TrackingNumber res) {
        res.setOriginCountryId(req.getOriginCountryId());
        res.setDestinationCountryId(req.getDestinationCountryId());
        res.setWeight(req.getWeight());
        res.setCreatedAt(req.getCreatedAt());
        res.setCustomerId(req.getCustomerId());
        res.setCustomerName(req.getCustomerName());
        res.setCustomerSlug(req.getCustomerSlug());
        return res;
    }

}
