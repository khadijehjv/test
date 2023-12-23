package com.example.demo.controller;


import com.example.demo.dto.LoginUserDTO;
import com.example.demo.dto.TokenDTO;
import com.example.demo.service.TokenGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("controller/v1/token")
public class TokenGenerationController {

    private final TokenGenerationService tokenGenerationService;

    @Autowired
    public TokenGenerationController(TokenGenerationService tokenGenerationService) {
        this.tokenGenerationService = tokenGenerationService;
    }

    @PostMapping
    public TokenDTO getToken(@RequestBody LoginUserDTO loginUserDTO) {
        return tokenGenerationService.getToken(loginUserDTO);
    }
}
