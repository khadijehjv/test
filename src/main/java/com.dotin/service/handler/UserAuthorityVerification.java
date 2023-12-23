package com.example.demo.service.handler;

import com.example.demo.domain.Authority;
import com.example.demo.domain.User;
import com.example.demo.dto.LoginUserDTO;
import com.example.demo.dto.UserCrudResponseDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserAuthorityVerification extends UserCRUDVerification{

    public UserAuthorityVerification(UserCRUDVerification nextVerification){
        super(nextVerification);
    }


    @Override
    public UserCrudResponseDTO isAuthorized(LoginUserDTO loginUserDTO, String authority) {
        Optional<User> userByUsername=UserRepoSiglt.userRepository.findUserByUsername(loginUserDTO.getUsername());
        //TODO clean these ifs with lambda


        if (!userByUsername.get().getAuthority().equals(authority)){
            return new UserCrudResponseDTO(true, Constants.USER_HAVE_NO_AUTHORITY_MESSAGE);
        } else if (super.nextVerification != null) {
            return nextVerification.isAuthorized(loginUserDTO,authority);
        }

        return new UserCrudResponseDTO(false,"No Error");
    }
}
