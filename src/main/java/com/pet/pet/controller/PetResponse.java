package com.pet.pet.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PetResponse {
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

    @JsonProperty("health")
    private int health;

    public PetResponse() {}

    public PetResponse(String id, String name, String ownerId, String type, int hunger, int happiness, int cleanliness, int health) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.type = type;
        this.hunger = hunger;
        this.happiness = happiness;
        this.cleanliness = cleanliness;
        this.health = health;
    }

    public PetResponse(String ownerId, String name, String type) {
        this.ownerId = ownerId;
        this.name = name;
        this.type = type;
    }

    // Getters and setters omitted for brevity

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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetResponse that = (PetResponse) o;
        return hunger == that.hunger && happiness == that.happiness && cleanliness == that.cleanliness && health == that.health && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(ownerId, that.ownerId) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ownerId, type, hunger, happiness, cleanliness, health);
    }
// ...
}
