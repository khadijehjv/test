package com.example.demo.service;

import com.example.demo.domain.Token;
import com.example.demo.domain.User;
import com.example.demo.dto.LoginUserDTO;
import com.example.demo.dto.TokenDTO;
import com.example.demo.repository.TokenRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.Constants;
import com.example.demo.utils.UserUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenGenerationService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;


    public TokenGenerationService(UserRepository userRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }


    public TokenDTO getToken(LoginUserDTO loginUserDTO) {


        Optional<User> userByUsername = userRepository.findUserByUsername(loginUserDTO.getUsername());

        if (!userByUsername.isPresent()) {
            return new TokenDTO(true, Constants.USER_NOT_FOUND_MESSAGE);
        }

        if (!UserUtils.CompareUserPassWithInput(userByUsername, loginUserDTO)) {
            return new TokenDTO(true, Constants.WRONG_PASSWORD_MESSAGE);
        }

        Optional<Token> tokenByUserId = tokenRepository.findByUsername(loginUserDTO.getUsername());

        if (!tokenByUserId.isPresent()) {
            Token generatedToken = generateToken(userByUsername.get());
            return new TokenDTO(generatedToken.getValue().toString());
        }

        return new TokenDTO(tokenByUserId.get().getValue().toString());
    }

    public Token generateToken(User user) {


        Token token = new Token();

//        token.setUser(user);
        token.setValue(UUID.randomUUID());
        Long currentDate = Timestamp.from(Instant.now()).getTime();
        token.setIssueDate(currentDate);
        token.setExpireDate(currentDate + Constants.USER_TOKEN_LIFE_TIME);
        user.setToken(token.getValue());
        //ToDO
//        userRepository.saveOrUpdateUser(user);
        return tokenRepository.save(token);
    }
}
