package com.social_media.service;

import com.social_media.dto.PostDto;
import com.social_media.entity.Post;
import com.social_media.mapper.MapStructMapper;
import com.social_media.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;
    private final MapStructMapper mapper;

    public PostDto createPost(PostDto postDto){
        Post post = mapper.toPost(postDto);
        return mapper.toPostDto(repository.save(post));
    }
    public List<PostDto> getPosts(int userId){
        return mapper.postListToPostDtoList(repository.findPostsByUserId(userId));
    }
}
