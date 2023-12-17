package com.social_media.dao;

import com.social_media.entity.Like;
import com.social_media.repository.LikeRepository;
import com.social_media.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeDao {
    public final LikeRepository repository;
    public Like addLike(Like like){
        return repository.save(like);
    }
}
