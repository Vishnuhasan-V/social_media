package com.social_media.dao;

import com.social_media.entity.Like;
import com.social_media.entity.Post;
import com.social_media.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostDao {
    private final PostRepository repository;
    public Post createPost(Post post){
        return repository.save(post);
    }
    public List<Post> getPosts(int postId){
        return repository.findPostsByUserId(postId);
    }
}
