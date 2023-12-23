package com.example.demo.service.handler;

import com.example.demo.domain.User;
import com.example.demo.dto.LoginUserDTO;
import com.example.demo.dto.UserCrudResponseDTO;
import com.example.demo.utils.Constants;
import com.example.demo.utils.UserUtils;

import java.util.Optional;

public class UserPasswordVerification extends UserCRUDVerification {

    public UserPasswordVerification(UserCRUDVerification nextVerification){
        super(nextVerification);
    }

    @Override
    public UserCrudResponseDTO isAuthorized(LoginUserDTO loginUserDTO, String authority) {
        Optional<User> userByUsername = UserRepoSiglt.userRepository.findUserByUsername(loginUserDTO.getUsername());
        //TODO clean these ifs with lambda



        if (!UserUtils.CompareUserPassWithInput(userByUsername, loginUserDTO)) {
            return new UserCrudResponseDTO(true, Constants.WRONG_PASSWORD_MESSAGE);
        } else if (super.nextVerification != null) {
            //TODO exception barname mitereke toye in halat
            return nextVerification.isAuthorized(loginUserDTO,authority);
        }

        return new UserCrudResponseDTO(false,"No Error");
    }
}