package com.pet.pet.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCreateRequest {

    @JsonProperty("name")
    private String name;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

}
