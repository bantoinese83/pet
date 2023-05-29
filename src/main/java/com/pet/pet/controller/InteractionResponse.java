package com.pet.pet.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class InteractionResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("petId")
    private String petId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("petResponse")
    private String petResponse;

    @JsonProperty("timestamp")
    private Instant timestamp;

    // Getters and setters omitted for brevity. Please implement them as in the request model.

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
        this.timestamp = Instant.now();

        if (this.petResponse == null) {
            this.petResponse = "";
        }

        if (this.petResponse.length() > 2000) {
            this.petResponse = this.petResponse.substring(0, 2000);
        }

        if (this.petResponse.length() < 1) {
            this.petResponse = "";
        }


    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }


}
