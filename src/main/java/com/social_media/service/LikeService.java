package com.social_media.service;

import com.social_media.dao.LikeDao;
import com.social_media.dto.LikeDto;
import com.social_media.entity.Like;
import com.social_media.mapper.MapStructMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeDao likeDao;

    private final MapStructMapper mapper;
    public LikeDto addLike(LikeDto likeDto){
        Like like = mapper.toLike(likeDto);
        return mapper.toLikeDto(likeDao.addLike(like));
    }

    public LikeDto getLike(int id){
        return mapper.toLikeDto(likeDao.getLike(id));
    }

    public List<LikeDto> getLikes(int postId){
        return mapper.likeListToLikeDtoList(likeDao.getLikes(postId));
    }
}