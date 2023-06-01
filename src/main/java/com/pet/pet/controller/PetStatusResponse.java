package com.pet.pet.controller;

public class PetStatusResponse {

    private String ownerId;
    private String name;
    private String type;
    private int health;
    private int hunger;
    private int happiness;

    public PetStatusResponse(String ownerId, String name, String type, int health, int hunger, int happiness) {
        this.ownerId = ownerId;
        this.name = name;
        this.type = type;
        this.health = health;
        this.hunger = hunger;
        this.happiness = happiness;
    }

    // Getters and setters
    // ...

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
}
