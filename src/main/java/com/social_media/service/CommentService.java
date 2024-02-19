package com.social_media.service;

import com.social_media.dto.CommentDto;
import com.social_media.entity.Comment;
import com.social_media.mapper.MapStructMapper;
import com.social_media.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository repository;
    private final MapStructMapper mapper;

    public CommentService(CommentRepository repository, MapStructMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CommentDto addComment(CommentDto commentDto){
        Comment comment = mapper.toComment(commentDto);
        return mapper.toCommentDto(repository.save(comment));
    }

    public CommentDto getComment(int id){
        return mapper.toCommentDto(repository.findById(id));
    }

    public List<CommentDto> getComments(int postId){
        return mapper.commentListToCommentDtoList(repository.findByPostId(postId));
    }
}