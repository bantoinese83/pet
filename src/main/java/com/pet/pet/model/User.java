package com.pet.pet.model;

import java.util.UUID;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "User")
public class User {
    private final String id;
    private String name;
    // other fields...

    public User() {
        this.id = UUID.randomUUID().toString();
        // other initialization code...
    }

    @DynamoDBHashKey
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute
    public String getName() {
        return name;
    }

    // getters and setters for other fields...
}
