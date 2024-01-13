package com.social_media.service;

import com.social_media.dto.UserDto;
import com.social_media.dao.UserDao;
import com.social_media.entity.User;
import com.social_media.mapper.MapStructMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    private final MapStructMapper mapper;

    public UserDto createUser(UserDto userDto){
        User user = mapper.toUser(userDto);
        return mapper.toUserDto(userDao.createUser(user));
    }
}
