package com.example.demo.service;


import com.example.demo.domain.User;
import com.example.demo.domain.converter.UserConverter;
import com.example.demo.dto.LoginUserDTO;
import com.example.demo.dto.UserCrudResponseDTO;
import com.example.demo.dto.UserFullInfoDTO;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.enums.AuthorityType;
import com.example.demo.service.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCRUDService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final UserCRUDVerification verificationChain ;


    @Autowired
    public UserCRUDService(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.verificationChain = getChainOfCRUDVerification();
    }

    public UserCrudResponseDTO createUser(LoginUserDTO currentUser, UserFullInfoDTO userFullInfoDTO){

        UserCrudResponseDTO responseDTO= verificationChain.isAuthorized(currentUser, AuthorityType.create.toString());

        if (!responseDTO.isError()){
            userRepository.save(UserConverter.userDTOToUser(userFullInfoDTO));
        }

        return responseDTO;
    }

    public UserFullInfoDTO getUser(LoginUserDTO currentUser,String username){

        UserCrudResponseDTO responseDTO= verificationChain.isAuthorized(currentUser,AuthorityType.read.toString());

        if (!responseDTO.isError()){
            return UserConverter.userToUserDTO(userRepository.findUserByUsername(username).get());
        }

        //chi bargardonim
        return new UserFullInfoDTO();

    }

    public UserCrudResponseDTO updateUser(LoginUserDTO currentUser,UserFullInfoDTO userFullInfoDTO){

        UserCrudResponseDTO responseDTO= verificationChain.isAuthorized(currentUser, AuthorityType.update.toString());


        //TODO if I want to change password we need hashing
        if (!responseDTO.isError()){
            User user=userRepository.findUserByUsername(userFullInfoDTO.getUsername()).get();
            userRepository.deleteById(user.getId());
            userRepository.save(UserConverter.userDTOToUser(userFullInfoDTO));
        }

       return responseDTO;
    }
    public UserCrudResponseDTO deleteUser(LoginUserDTO currentUser,String username){

        UserCrudResponseDTO responseDTO= verificationChain.isAuthorized(currentUser,AuthorityType.delete.toString());
        User user =userRepository.findUserByUsername(username).get();

        if (!responseDTO.isError()){
            userRepository.deleteById(user.getId());
        }

        return responseDTO;
    }

    private static UserCRUDVerification getChainOfCRUDVerification() {
        UserCRUDVerification userTokenVerification= new UserTokenVerification(null);
        UserCRUDVerification userAuthorityVerification = new UserAuthorityVerification(userTokenVerification);
        UserCRUDVerification userPasswordVerification=new UserPasswordVerification(userAuthorityVerification);
        return new UserExistenceVerification(userPasswordVerification);
    }
}
