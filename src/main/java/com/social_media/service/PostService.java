package com.social_media.service;

import com.social_media.dto.PostDto;
import com.social_media.entity.Post;
import com.social_media.mapper.MapStructMapper;
import com.social_media.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository repository;
    private final MapStructMapper mapper;

    public PostService(PostRepository repository, MapStructMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PostDto createPost(PostDto postDto){
        Post post = mapper.toPost(postDto);
        return mapper.toPostDto(repository.save(post));
    }

    public PostDto getPost(int postId){
        return mapper.toPostDto(repository.findPostById(postId));
    }

    public List<PostDto> getPosts(int userId){
        return mapper.postListToPostDtoList(repository.findByUserId(userId));
    }
}
