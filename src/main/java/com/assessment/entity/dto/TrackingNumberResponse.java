package com.assessment.entity.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrackingNumberResponse {

    private String trackingNumber;
    private OffsetDateTime createdAt;
    private OffsetDateTime createdTimestamp;

    public TrackingNumberResponse() {
    }

    public TrackingNumberResponse(String trackingNumber, OffsetDateTime createdAt, OffsetDateTime createdTimestamp) {
        this.trackingNumber = trackingNumber;
        this.createdAt = createdAt;
        this.createdTimestamp = createdTimestamp;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(OffsetDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

}

