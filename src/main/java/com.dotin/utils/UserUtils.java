package com.example.demo.utils;

import com.example.demo.domain.User;
import com.example.demo.dto.LoginUserDTO;

import java.util.Optional;

public final class UserUtils {

    public static boolean CompareUserPassWithInput(Optional<User> userByUsername, LoginUserDTO user) {
        String dbPassword = userByUsername.get().getPassword();
        String inputPassword = PBKDF2Hashing.toHash(user.getPassword());

        if (dbPassword.equals(inputPassword)){
            return true;
        }
        return false;
    }
}