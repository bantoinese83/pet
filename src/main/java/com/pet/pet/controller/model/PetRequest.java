package com.pet.pet.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PetRequest {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("ownerId")
    private String ownerId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("hunger")
    private int hunger;

    @JsonProperty("happiness")
    private int happiness;

    @JsonProperty("cleanliness")
    private int cleanliness;

    public PetRequest() {}

    public PetRequest(String id, String name, String ownerId, String type, int hunger, int happiness, int cleanliness) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.type = type;
        this.hunger = hunger;
        this.happiness = happiness;
        this.cleanliness = cleanliness;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

}
