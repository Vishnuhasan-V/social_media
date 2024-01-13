package com.social_media.dao;

import com.social_media.entity.Comment;
import com.social_media.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentDao {
    private final CommentRepository repository;
    public Comment addComment(Comment comment){
        return repository.save(comment);
    }
    public Comment getComment(int id){
        return repository.findCommentById(id);
    }
    public List<Comment> getComments(int postId){
        return repository.findCommentsPostId(postId);
    }
}
