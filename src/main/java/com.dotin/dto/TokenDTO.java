package com.example.demo.dto;

public class TokenDTO {

    private Boolean error;
    private String errorMessage;
    private String token;


    public TokenDTO(Boolean error, String errorMessage) {
        this.error = error;
        this.errorMessage = errorMessage;
    }

    public TokenDTO(String token){
        setToken(token);
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
