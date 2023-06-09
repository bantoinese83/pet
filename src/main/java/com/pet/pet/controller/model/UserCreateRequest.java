package com.pet.pet.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCreateRequest {
    @JsonProperty("email")

    private String email;

    @JsonProperty("password")

    private String password;

    public UserCreateRequest() {}

    public UserCreateRequest( String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

