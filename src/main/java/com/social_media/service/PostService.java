package com.social_media.service;

import com.social_media.dao.PostDao;
import com.social_media.dto.PostDto;
import com.social_media.entity.Post;
import com.social_media.mapper.MapStructMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    public final PostDao postDao;
    private final MapStructMapper mapper;

    public PostDto createPost(PostDto postDto){
        Post post = mapper.toPost(postDto);
        return mapper.toPostDto(postDao.createPost(post));
    }
}