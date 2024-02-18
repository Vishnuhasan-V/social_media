package com.social_media.service;

import com.social_media.dto.UserDto;
import com.social_media.entity.User;
import com.social_media.mapper.MapStructMapper;
import com.social_media.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    private final MapStructMapper mapper;

    public UserService(UserRepository repository, MapStructMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UserDto createUser(UserDto userDto){
        User user = mapper.toUser(userDto);
        return mapper.toUserDto(repository.save(user));
    }
}
