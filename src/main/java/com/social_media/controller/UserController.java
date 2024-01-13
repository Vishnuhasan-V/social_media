package com.social_media.controller;


import com.social_media.dto.UserDto;
import com.social_media.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }
}
