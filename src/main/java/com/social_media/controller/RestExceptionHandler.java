package com.social_media.controller;

import com.social_media.exception.InvalidRequestException;
import com.social_media.response.SpdResponse;
import com.social_media.response.error.SpdErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = InvalidRequestException.class)
    public ResponseEntity<String> handleInvalidRequestException(InvalidRequestException e){
        SpdResponse spdResponse = new SpdResponse();
        spdResponse.setErrorMsg("Bad Request");
        spdResponse.setSpdErrorResponse(new SpdErrorResponse(e.getMessage(),400));
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
