package com.social_media.dao;

import com.social_media.entity.Comment;
import com.social_media.entity.Like;
import com.social_media.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeDao {
    private final LikeRepository repository;
    public Like addLike(Like like){
        return repository.save(like);
    }
    public Like getLike(int id){
        return repository.findLikeById(id);
    }
    public List<Like> getLikes(int postId){
        return repository.findLikesPostId(postId);
    }
}
