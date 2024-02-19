package com.social_media.response.error;

public enum EnumErrorType {

    INVALID_REQUEST("E001", "Invalid Request");
    String code;
    String errorMessage;

    EnumErrorType(String code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public String getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}