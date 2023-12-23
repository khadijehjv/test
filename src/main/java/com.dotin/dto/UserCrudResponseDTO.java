package com.example.demo.dto;

import com.example.demo.domain.User;

public class UserCrudResponseDTO {
    private boolean error;
    private String errorMassage;
    private User user;


    public UserCrudResponseDTO(boolean error, String errorMassage) {
        this.error = error;
        this.errorMassage= errorMassage;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorMassage() {
        return errorMassage;
    }

    public void setErrorMassage(String errorMassage) {
        this.errorMassage = errorMassage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
