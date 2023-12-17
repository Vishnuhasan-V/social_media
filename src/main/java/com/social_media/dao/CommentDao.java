package com.social_media.dao;

import com.social_media.entity.Comment;
import com.social_media.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentDao {
    public final CommentRepository repository;
    public Comment addComment(Comment comment){
        return repository.save(comment);
    }
}
