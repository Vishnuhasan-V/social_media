package com.social_media.controller;

import com.social_media.dto.CommentDto;
import com.social_media.exception.InvalidRequestException;
import com.social_media.response.SpdResponse;
import com.social_media.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/add-comment")
    public ResponseEntity<SpdResponse<CommentDto>> addComment(@RequestBody CommentDto commentDto){
        validateRequest(commentDto);
        SpdResponse<CommentDto> spdResponse = new SpdResponse<>();
        spdResponse.setData(commentService.addComment(commentDto));
        spdResponse.setSuccessMsg("Comment added successfully");
        return new ResponseEntity<>(spdResponse, HttpStatus.CREATED);
    }

    @GetMapping("/comment")
    public ResponseEntity<SpdResponse<CommentDto>> getComment(@RequestParam("id") int id){
        validateId(id);
        SpdResponse<CommentDto> spdResponse = new SpdResponse<>();
        spdResponse.setData(commentService.getComment(id));
        spdResponse.setSuccessMsg("Done");
        return new ResponseEntity<>(spdResponse, HttpStatus.OK);
    }

    @GetMapping("/post/{postId}/comments")
    public ResponseEntity<SpdResponse<List<CommentDto>>> getComments(@PathVariable int postId){
        validateId(postId);
        SpdResponse<List<CommentDto>> spdResponse = new SpdResponse<>();
        spdResponse.setData(commentService.getComments(postId));
        spdResponse.setSuccessMsg("Done");
        return new ResponseEntity<>(spdResponse, HttpStatus.OK);
    }

    private void validateRequest(CommentDto commentDto){
        if(!isValidId(commentDto.getUserId())){
            throw new InvalidRequestException("User Id should be valid");
        }
        if(!isValidId(commentDto.getPostId())){
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
