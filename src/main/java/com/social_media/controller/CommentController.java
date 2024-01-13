package com.social_media.controller;

import com.social_media.dto.CommentDto;
import com.social_media.dto.LikeDto;
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
}
