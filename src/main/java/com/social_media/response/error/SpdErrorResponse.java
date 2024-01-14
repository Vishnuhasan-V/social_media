package com.social_media.response.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpdErrorResponse {
    @JsonProperty("message")
    private String errorMessage;
    @JsonProperty("code")
    private int errorCode;

    public SpdErrorResponse(String errorMessage, int errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

}