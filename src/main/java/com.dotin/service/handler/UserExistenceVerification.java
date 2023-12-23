package com.example.demo.service.handler;

import com.example.demo.domain.User;
import com.example.demo.dto.LoginUserDTO;
import com.example.demo.dto.UserCrudResponseDTO;
import com.example.demo.utils.Constants;
import com.example.demo.utils.PBKDF2Hashing;

import java.security.SecureRandom;
import java.util.Optional;

public class UserExistenceVerification extends UserCRUDVerification{



    public UserExistenceVerification(UserCRUDVerification nextVerification) {
        super(nextVerification);
    }



    @Override
    public UserCrudResponseDTO isAuthorized(LoginUserDTO loginUserDTO, String authority) {
        Optional<User> userByUsername = UserRepoSiglt.userRepository.findUserByUsername(loginUserDTO.getUsername());

        if (!userByUsername.isPresent()) {
            return new UserCrudResponseDTO(true, Constants.USER_NOT_FOUND_MESSAGE);
        } else if (super.nextVerification != null) {
            return nextVerification.isAuthorized(loginUserDTO,authority);
        }

        return new UserCrudResponseDTO(false,"No Error");
    }
}
