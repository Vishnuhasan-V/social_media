package com.social_media.controller;

import com.social_media.dto.PostDto;
import com.social_media.exception.InvalidRequestException;
import com.social_media.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/add-post")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }
    @GetMapping("user/{userId}/likes")
    public ResponseEntity<List<PostDto>> getPosts(@PathVariable int userId){
        return new ResponseEntity<>(postService.getPosts(userId), HttpStatus.OK);
    }

    private void validateRequest(PostDto postDto){
        if(isValidId(postDto.getUserId())){
            throw new InvalidRequestException("User Id should be valid");
        }
        if(isValidContent(postDto.getContent())){
            throw new InvalidRequestException("Content can not be empty");
        }
    }

    private boolean isValidId(int userId){
        return userId > 0;
    }

    private boolean isValidContent(String content){
        return content != null && !content.trim().isEmpty();
    }
}
