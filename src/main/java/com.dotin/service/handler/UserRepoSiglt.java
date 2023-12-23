package com.example.demo.service.handler;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepoSiglt {

    public static UserRepository userRepository;

    @Autowired
    UserRepoSiglt(UserRepository userRepository){
        this.userRepository=userRepository;
    }

}

