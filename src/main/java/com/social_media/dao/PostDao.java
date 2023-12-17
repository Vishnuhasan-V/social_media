package com.social_media.dao;

import com.social_media.entity.Post;
import com.social_media.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostDao {
    public final PostRepository repository;
    public Post createPost(Post post){
        return repository.save(post);
    }
}
