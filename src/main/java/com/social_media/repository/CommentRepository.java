package com.social_media.repository;

import com.social_media.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    Comment findById(int id);

    List<Comment> findByPostId(int postId);

}
