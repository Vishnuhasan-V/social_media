package com.social_media.service;

import com.social_media.dao.LikeDao;
import com.social_media.dto.LikeDto;
import com.social_media.entity.Like;
import com.social_media.mapper.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    public final LikeDao likeDao;
    private final EntityMapper mapper;
    public LikeDto addLike(LikeDto likeDto){
        Like like = mapper.toLike(likeDto);
        return mapper.toLikeDto(likeDao.addLike(like));
    }
}