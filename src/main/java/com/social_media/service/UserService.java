package com.social_media.service;

import com.social_media.dto.UserDto;
import com.social_media.dao.UserDao;
import com.social_media.entity.User;
import com.social_media.mapper.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserDao userDao;
    private final EntityMapper mapper;

    public UserDto createUser(UserDto userDto){
        User user = mapper.toUser(userDto);
        return mapper.toUserDto(userDao.createUser(user));
    }
}
