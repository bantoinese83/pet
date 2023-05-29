package com.pet.pet.controller;

import java.time.Instant;

public class InteractionRecord {
    private String id;
    private String petId;
    private String type;
    private String petResponse;
    private Instant timestamp;

    public InteractionRecord() {}

    public InteractionRecord(String id, String petId, String type, String petResponse, Instant timestamp) {
        this.id = id;
        this.petId = petId;
        this.type = type;
        this.petResponse = petResponse;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPetResponse() {
        return petResponse;
    }

    public void setPetResponse(String petResponse) {
        this.petResponse = petResponse;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
