package com.social_media.controller;


import com.social_media.dto.UserDto;
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
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        validateRequest(userDto);
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    public void validateRequest(UserDto userDto){

        if (!isValidEmail(userDto.getEmail())){
            throw new RuntimeException("Email should be valid");
        }
        if (!isValidName(userDto.getName())){
            throw new RuntimeException("Name should be valid");
        }
        if (!isValidPassword(userDto.getPassword())){
            throw new RuntimeException("Password should be valid");
        }
    }


    public static boolean isValidEmail(String email) {
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public boolean isValidName(String name){
        String namePattern = "^[A-Za-z ]+$";
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public boolean isValidPassword(String password){
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
