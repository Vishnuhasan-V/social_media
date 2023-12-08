package com.social_media.controller;

import com.social_media.dto.LikeDto;
import com.social_media.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {
    @Autowired
    LikeService likeService;

    @PostMapping("/like")
    public ResponseEntity<LikeDto> addLike(@RequestBody LikeDto likeDto){
        return new ResponseEntity<>(likeService.addLike(likeDto), HttpStatus.CREATED);
    }
}
