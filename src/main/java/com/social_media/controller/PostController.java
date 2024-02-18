package com.social_media.controller;

import com.social_media.dto.PostDto;
import com.social_media.exception.InvalidRequestException;
import com.social_media.response.SpdResponse;
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
    public ResponseEntity<SpdResponse<PostDto>> createPost(@RequestBody PostDto postDto){
        validateRequest(postDto);
        SpdResponse<PostDto> spdResponse = new SpdResponse<>();
        spdResponse.setData(postService.createPost(postDto));
        spdResponse.setSuccessMsg("Post created successfully");
        return new ResponseEntity<>(spdResponse, HttpStatus.CREATED);
    }
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<SpdResponse<List<PostDto>>> getPostsByUser(@PathVariable int userId){
        validateId(userId);
        SpdResponse<List<PostDto>> spdResponse = new SpdResponse<>();
        spdResponse.setData(postService.getPosts(userId));
        return new ResponseEntity<>(spdResponse, HttpStatus.OK);
    }

    @GetMapping("/post")
    public ResponseEntity<SpdResponse<PostDto>> getPost(@RequestParam("id") int postId){
        validateId(postId);
        SpdResponse<PostDto> spdResponse = new SpdResponse<>();
        spdResponse.setData(postService.getPost(postId));
        return new ResponseEntity<>(spdResponse, HttpStatus.OK);
    }
    private void validateRequest(PostDto postDto){
        if(!isValidId(postDto.getUserId())){
            throw new InvalidRequestException("User Id should be valid");
        }
        if(!isValidContent(postDto.getContent())){
            throw new InvalidRequestException("Content can not be empty");
        }
    }

    private void validateId(int id){
        if(!isValidId(id)){
            throw new InvalidRequestException("User Id should be valid");
        }
    }

    private boolean isValidId(int userId){
        return userId > 0;
    }

    private boolean isValidContent(String content){
        return content != null && !content.trim().isEmpty();
    }
}
