package com.social_media.controller;

import com.social_media.dto.LikeDto;
import com.social_media.exception.InvalidRequestException;
import com.social_media.response.SpdResponse;
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
    public ResponseEntity<SpdResponse<LikeDto>> addLike(@RequestBody LikeDto likeDto){
        validateRequest(likeDto);
        SpdResponse<LikeDto> spdResponse = new SpdResponse<>();
        spdResponse.setData(likeService.addLike(likeDto));
        return new ResponseEntity<>(spdResponse, HttpStatus.CREATED);
    }
    @GetMapping("/like")
    public ResponseEntity<SpdResponse<LikeDto>> getLike(@RequestParam("id") int id){
        validateId(id);
        SpdResponse<LikeDto> spdResponse = new SpdResponse<>();
        spdResponse.setData(likeService.getLike(id));
        return new ResponseEntity<>(spdResponse, HttpStatus.OK);
    }

    @GetMapping("/post/{postId}/likes")
    public ResponseEntity<SpdResponse<List<LikeDto>>> getLikes(@PathVariable int postId){
        validateId(postId);
        SpdResponse<List<LikeDto>> spdResponse = new SpdResponse<>();
        spdResponse.setData(likeService.getLikes(postId));
        return new ResponseEntity<>(spdResponse, HttpStatus.OK);
    }

    private void validateRequest(LikeDto likeDto){
        if(!isValidId(likeDto.getUserId())){
            throw new InvalidRequestException("User Id should be valid");
        }
        if(!isValidId(likeDto.getPostId())){
            throw new InvalidRequestException("Post Id should be valid");
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
}
