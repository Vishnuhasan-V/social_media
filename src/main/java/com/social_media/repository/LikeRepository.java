package com.social_media.repository;

import com.social_media.entity.Like;
import com.social_media.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like,Integer> {
    Like findLikeById(int id);
}
