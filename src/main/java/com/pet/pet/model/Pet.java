package com.pet.pet.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.pet.pet.controller.PetRecord;

import java.util.Objects;


@DynamoDBTable(tableName = "Pet")
public class Pet {

    private String id;
    private String name;
    private String ownerId;
    private String type;
    private int hunger;
    private int happiness;
    private int cleanliness;
    private int health;

    public Pet() {}

    public Pet(PetRecord record) {
        this.id = record.getId();
        this.name = record.getName();
        this.ownerId = record.getOwnerId();
        this.type = record.getType();
        this.hunger = record.getHunger();
        this.happiness = record.getHappiness();
        this.cleanliness = record.getCleanliness();
        this.health = record.getHealth();
    }

    public Pet(String ownerId, String name, String type) {
        this.ownerId = ownerId;
        this.name = name;
        this.type = type;
    }
    @DynamoDBHashKey
    public String getId() {
        return id;
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

    public PetRecord toPetRecord() {
        PetRecord record = new PetRecord();
        record.setId(this.id);
        record.setName(this.name);
        record.setOwnerId(this.ownerId);
        record.setType(this.type);
        record.setHunger(this.hunger);
        record.setHappiness(this.happiness);
        record.setCleanliness(this.cleanliness);
        record.setHealth(this.health);
        return record;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Pet other = (Pet) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
