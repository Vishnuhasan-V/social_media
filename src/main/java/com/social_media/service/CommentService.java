package com.social_media.service;

import com.social_media.dao.CommentDao;
import com.social_media.dto.CommentDto;
import com.social_media.entity.Comment;
import com.social_media.mapper.MapStructMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    public final CommentDao commentDao;
    private final MapStructMapper mapper;
    public CommentDto addComment(CommentDto commentDto){
        Comment comment = mapper.toComment(commentDto);
        return mapper.toCommentDto(commentDao.addComment(comment));
    }
}