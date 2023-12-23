package com.example.demo.service.handler;

import com.example.demo.dto.LoginUserDTO;
import com.example.demo.dto.UserCrudResponseDTO;

public abstract class UserCRUDVerification{
    public UserCRUDVerification nextVerification;

    public UserCRUDVerification(UserCRUDVerification nextVerification) {
        this.nextVerification = nextVerification;
    }

    public abstract UserCrudResponseDTO isAuthorized(LoginUserDTO loginUserDTO, String authority);



}
