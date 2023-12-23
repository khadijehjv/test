package com.example.demo.repository;

import com.example.demo.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {


    Token save(Token token);

    Optional<Token> findByUsername(String username);

}
