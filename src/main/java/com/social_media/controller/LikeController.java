package com.social_media.controller;

import com.social_media.dto.CommentDto;
import com.social_media.dto.LikeDto;
import com.social_media.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikeController {
    @Autowired
    LikeService likeService;

    @PostMapping("/add-like")
    public ResponseEntity<LikeDto> addLike(@RequestBody LikeDto likeDto){
        return new ResponseEntity<>(likeService.addLike(likeDto), HttpStatus.CREATED);
    }
    @GetMapping("/like/{id}")
    public ResponseEntity<LikeDto> getLike(@PathVariable int id){
        return new ResponseEntity<>(likeService.getLike(id), HttpStatus.OK);
    }

    @GetMapping("post/{postId}/likes")
    public ResponseEntity<List<LikeDto>> getLikes(@PathVariable int postId){
        return new ResponseEntity<>(likeService.getLikes(postId), HttpStatus.OK);
    }
}
