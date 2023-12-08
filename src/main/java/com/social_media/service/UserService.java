package com.social_media.service;

import com.social_media.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDto createUser(UserDto userDto){
        return userDto;
    }
}
