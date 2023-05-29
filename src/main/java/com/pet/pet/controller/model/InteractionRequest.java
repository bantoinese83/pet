package com.pet.pet.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InteractionRequest {

    @JsonProperty("petId")
    private String petId;

    @JsonProperty("type")
    private String type;

    // No petResponse here as this is a request model.

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
}
