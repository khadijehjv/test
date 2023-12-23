package com.example.demo.domain.converter;

import com.example.demo.domain.User;
import com.example.demo.dto.UserFullInfoDTO;

public class UserConverter {

    public static User userDTOToUser(UserFullInfoDTO userFullInfoDTO) {
        User user = new User();

        //TODO handle exceptions
        user.setUsername(userFullInfoDTO.getUsername());
        user.setPassword(userFullInfoDTO.getPassword());
        user.setFirstName(userFullInfoDTO.getFirstname());
        user.setLastName(userFullInfoDTO.getLastname());
        user.setBirthDate(userFullInfoDTO.getBirthDate());
        user.setNationalCode(userFullInfoDTO.getNationalCode());
//        Authority authority= new Authority();
//        authority.setAuthority(userFullInfoDTO.getAuthority());
//        authority.setUser(user);
//        user.setAuthority(userFullInfoDTO.getAuthority());
        return user;
    }

    public static UserFullInfoDTO userToUserDTO(User user) {
        UserFullInfoDTO userFullInfoDTO = new UserFullInfoDTO(user.getUsername(),user.getPassword(),user.getBirthDate(),user.getNationalCode(),
                user.getFirstName(),user.getLastName(),user.getAuthority(),user.getToken().toString());

        return userFullInfoDTO;
    }

}
