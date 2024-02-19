package com.social_media.service;

import com.social_media.dto.LikeDto;
import com.social_media.entity.Like;
import com.social_media.mapper.MapStructMapper;
import com.social_media.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    private LikeRepository repository;

    private MapStructMapper mapper;

    public LikeService(LikeRepository repository, MapStructMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public LikeDto addLike(LikeDto likeDto){
        Like like = mapper.toLike(likeDto);
        return mapper.toLikeDto(repository.save(like));
    }

    public LikeDto getLike(int id){
        return mapper.toLikeDto(repository.findById(id));
    }

    public List<LikeDto> getLikes(int postId){
        return mapper.likeListToLikeDtoList(repository.findByPostId(postId));
    }
}