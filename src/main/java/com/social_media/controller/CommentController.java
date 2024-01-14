package com.social_media.controller;

import com.social_media.dto.CommentDto;
import com.social_media.exception.InvalidRequestException;
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
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.addComment(commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<CommentDto> getComment(@PathVariable int id){
        return new ResponseEntity<>(commentService.getComment(id), HttpStatus.OK);
    }

    @GetMapping("post/{postId}/comments")
    public ResponseEntity<List<CommentDto>> getComments(@PathVariable int postId){
        return new ResponseEntity<>(commentService.getComments(postId), HttpStatus.OK);
    }

    private void validateRequest(CommentDto commentDto){
        if(isValidId(commentDto.getUserId())){
            throw new InvalidRequestException("User Id should be valid");
        }
        if(isValidId(commentDto.getPostId())){
            throw new InvalidRequestException("Post Id should be valid");
        }

    }

    private boolean isValidId(int userId){
        return userId > 0;
    }
}
