package com.social_media.dao;

import com.social_media.entity.User;
import com.social_media.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDao {
    private final UserRepository repository;
    public User createUser(User user){
        return repository.save(user);
    }

}
