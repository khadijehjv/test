package com.example.demo.service.handler;

import com.example.demo.domain.Token;
import com.example.demo.domain.User;
import com.example.demo.dto.LoginUserDTO;
import com.example.demo.dto.UserCrudResponseDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

public class UserTokenVerification extends UserCRUDVerification {





    public UserTokenVerification(UserCRUDVerification nextVerification){
        super(nextVerification);
    }

    @Override
    public UserCrudResponseDTO isAuthorized(LoginUserDTO loginUserDTO, String authority) {

        Optional<User> userByUsername=UserRepoSiglt.userRepository.findUserByUsername(loginUserDTO.getUsername());
        //TODO clean these ifs with lambda

        //userByUsername.get().getExpireDate().compareTo(Timestamp.from(Instant.now()).getTime())<0
        if (userByUsername.get().getToken().equals(null)){
            return new UserCrudResponseDTO(true, Constants.USER_HAVE_NO_AUTHORITY_MESSAGE);
        } else if (super.nextVerification != null) {
            return nextVerification.isAuthorized(loginUserDTO,authority);
        }

        return new UserCrudResponseDTO(false,"No Error");
    }
}
