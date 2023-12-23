package com.example.demo.dto;

import com.example.demo.controller.json.JsonArg;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class LoginUserDTO {

    //TODO better pattern

    @JsonProperty(value = "username")
    @NotBlank
    private String username;
    @JsonProperty(value = "password")
    @NotBlank
    private String password;


    public LoginUserDTO() {
    }

    public LoginUserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
