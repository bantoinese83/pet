package com.pet.pet.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

@DynamoDBTable(tableName = "Pet")
public class Pet {

    private String id;
    private String name;
    private String ownerId;
    private String type;

    @DynamoDBHashKey(attributeName = "Id")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "Name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "OwnerId")
    public String getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @DynamoDBAttribute(attributeName = "Type")
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
