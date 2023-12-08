package com.social_media.service;

import com.social_media.dto.CommentDto;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    public CommentDto addComment(CommentDto commentDto){
        return commentDto;
    }
}