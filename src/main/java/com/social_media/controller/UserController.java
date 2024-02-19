package com.social_media.controller;


import com.social_media.dto.UserDto;
import com.social_media.exception.InvalidRequestException;
import com.social_media.response.SpdResponse;
import com.social_media.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<SpdResponse<UserDto>> createUser(@RequestBody UserDto userDto){
        validateRequest(userDto);
        SpdResponse<UserDto> spdResponse = new SpdResponse<>();
        spdResponse.setData(userService.createUser(userDto));
        spdResponse.setSuccessMsg("User created successfully");
        return new ResponseEntity<>(spdResponse, HttpStatus.CREATED);
    }

    private void validateRequest(UserDto userDto){

        if (!isValidEmail(userDto.getEmail())){
            throw new InvalidRequestException("Email should be valid");
        }
        if (!isValidName(userDto.getName())){
            throw new InvalidRequestException("Name should be valid");
        }
        if (!isValidPassword(userDto.getPassword())){
            throw new InvalidRequestException("Password should be valid");
        }
    }


    private static boolean isValidEmail(String email) {
        String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private boolean isValidName(String name){
        String namePattern = "^[A-Za-z ]+$";
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    private boolean isValidPassword(String password){
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
