package com.social_media.response.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpdErrorResponse {
    @JsonProperty("message")
    private String errorMessage;
    @JsonProperty("error")
    private EnumErrorType enumErrorType;

    public SpdErrorResponse(String errorMessage, EnumErrorType enumErrorType) {
        this.errorMessage = errorMessage;
        this.enumErrorType = enumErrorType;
    }

}