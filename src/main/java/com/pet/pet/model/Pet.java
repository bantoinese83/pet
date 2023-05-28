package com.pet.pet.model;

import java.util.UUID;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

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

    public Pet() {
        this.id = UUID.randomUUID().toString();
        // other initialization code...
        this.health = 100; // initial health
    }

    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "name")
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @DynamoDBAttribute(attributeName = "ownerId")
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public String getOwnerId() {
        return ownerId;
    }

    @DynamoDBAttribute(attributeName = "type")
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    @DynamoDBAttribute(attributeName = "Hunger")
    public void setHunger(int hunger) {
        this.hunger = hunger;
        calculateHealth();
    }
    public int getHunger() {
        return hunger;
    }

    @DynamoDBAttribute(attributeName = "happiness")
    public void setHappiness(int happiness) {
        this.happiness = happiness;
        calculateHealth();
    }
    public int getHappiness() {
        return happiness;
    }

    @DynamoDBAttribute(attributeName = "cleanliness")
    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
        calculateHealth();
    }
    public int getCleanliness() {
        return cleanliness;
    }

    @DynamoDBAttribute(attributeName = "health")
    public int getHealth() {
        return health;
    }

    private void calculateHealth() {
        // Adjust these calculations as needed for your game logic
        this.health = (100 - hunger) / 3 + happiness / 3 + cleanliness / 3;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
