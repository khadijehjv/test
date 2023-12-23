package com.example.demo.controller;

import com.example.demo.controller.json.JsonArg;
import com.example.demo.controller.routes.Routes;
import com.example.demo.dto.LoginUserDTO;
import com.example.demo.dto.UserCrudResponseDTO;
import com.example.demo.dto.UserFullInfoDTO;
import com.example.demo.service.UserCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

//TODO DOCUMENT

@RestController
@RequestMapping(Routes.USER_CRUD_CONTROLLER)
public class UserCRUDController {

    private final UserCRUDService userCRUDService;

    @Autowired
    public UserCRUDController(UserCRUDService userCRUDService) {
        this.userCRUDService = userCRUDService;
    }


    @PutMapping("/create")
    public UserCrudResponseDTO createUser(@JsonArg("currentUser") LoginUserDTO currentUser, @JsonArg("userInfo") UserFullInfoDTO userFullInfoDTO) {
        return userCRUDService.createUser(currentUser, userFullInfoDTO);
    }

    @GetMapping("/get")
    public UserFullInfoDTO getUser(@JsonArg("currentUser") LoginUserDTO currentUser, @JsonArg("username") @NotBlank String username) {
        return userCRUDService.getUser(currentUser, username);
    }

    @PostMapping("/update")
    public UserCrudResponseDTO editUser(@JsonArg("currentUser") LoginUserDTO currentUser, @JsonArg("userInfo") UserFullInfoDTO userFullInfoDTO) {
        LoginUserDTO ll = currentUser;
        return userCRUDService.updateUser(currentUser, userFullInfoDTO);
    }


    @DeleteMapping("/delete")
    public UserCrudResponseDTO deleteUser(@JsonArg("currentUser") LoginUserDTO currentUser, @JsonArg("username") @NotBlank String username) {
        LoginUserDTO ll = currentUser;
        return userCRUDService.deleteUser(currentUser, username);
    }
}