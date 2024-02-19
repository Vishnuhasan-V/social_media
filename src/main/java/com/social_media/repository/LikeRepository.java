package com.social_media.repository;

import com.social_media.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like,Integer> {
    Like findById(int id);
    List<Like> findByPostId(int postId);

}
