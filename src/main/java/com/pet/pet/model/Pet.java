package com.pet.pet.model;

import java.util.UUID;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

@DynamoDBTable(tableName = "Pet")
public class Pet {

    private final String id;
    private String name;
    private String ownerId;
    private String type;
    private int hunger;
    private int happiness;
    private int cleanliness;

    public Pet() {
        this.id = UUID.randomUUID().toString();
        // other initialization code...
    }

    @DynamoDBHashKey(attributeName = "Id")
    public String getId() {
        return id;
    }

    @DynamoDBAttribute(attributeName = "Name")
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @DynamoDBAttribute(attributeName = "OwnerId")
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public String getOwnerId() {
        return ownerId;
    }

    @DynamoDBAttribute(attributeName = "Type")
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    @DynamoDBAttribute(attributeName = "Hunger")
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
    public int getHunger() {
        return hunger;
    }

    @DynamoDBAttribute(attributeName = "Happiness")
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }
    public int getHappiness() {
        return happiness;
    }

    @DynamoDBAttribute(attributeName = "Cleanliness")
    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }
    public int getCleanliness() {
        return cleanliness;
    }
}
