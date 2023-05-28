package com.pet.pet.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.time.Instant;

@DynamoDBTable(tableName = "Interactions")
public class Interaction {

    private String id;
    private String petId;
    private String type;
    private String petResponse;  // New field
    private Instant timestamp;

    @DynamoDBHashKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute
    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    @DynamoDBAttribute
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @DynamoDBAttribute  // Attribute annotation for the new field
    public String getPetResponse() {
        return petResponse;
    }

    public void setPetResponse(String petResponse) {
        this.petResponse = petResponse;
    }

    @DynamoDBRangeKey
    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
