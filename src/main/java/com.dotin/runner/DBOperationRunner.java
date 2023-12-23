package com.example.demo.runner;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.PBKDF2Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;


@Component
public class DBOperationRunner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        String pass = PBKDF2Hashing.toHash("123");
        String pass2 = PBKDF2Hashing.toHash("123");

        userRepository.saveAll(Arrays.asList(

                new User("anahita", pass, 14021223L, 21, "ana", "mohamadi", "create", UUID.randomUUID()),
                new User("ali", pass2, 14021223L, 22, "ali", "mohamadi", "read", UUID.randomUUID()),
                new User("ana", pass, 14021223L, 23, "ana", "mohamadi", "update", UUID.randomUUID()),
                new User("sana", pass, 14021223L, 24, "sana", "mohamadi", "delete", UUID.randomUUID()))
        );
    }
}
