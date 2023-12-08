package com.social_media.controller;

import com.social_media.dto.CommentDto;
import com.social_media.dto.LikeDto;
import com.social_media.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/comment")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.addComment(commentDto), HttpStatus.CREATED);
    }
}
