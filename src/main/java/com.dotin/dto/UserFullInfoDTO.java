package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class UserFullInfoDTO {

    //TODO make inheritance to clean code

    @NotBlank
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("nationalCode")
    private int nationalCode;

    @JsonProperty("birthDate")
    private Long birthDate;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("token")
    private String token;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("authority")
    private String authority;

    public UserFullInfoDTO(){
    }

    public UserFullInfoDTO(String username, String password, Long birthDate, int nationalCode,  String firstname,  String lastname, String authority ,String token) {
        this.username = username;
        this.password = password;
        this.nationalCode = nationalCode;
        this.birthDate = birthDate;
        this.firstname = firstname;
        this.token = token;
        this.lastname = lastname;
        this.authority = authority;
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

    public int getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }


    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
