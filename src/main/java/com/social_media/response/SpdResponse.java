package com.social_media.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.social_media.response.error.SpdErrorResponse;


public class SpdResponse<T> {
    @JsonProperty("data")
    private T data;
    @JsonProperty("success_msg")
    protected String successMsg;
    @JsonProperty("error_msg")
    protected String errorMsg;
    @JsonProperty("error")
    private SpdErrorResponse spdErrorResponse;

    public T getData() {
        return this.data;
    }

    @JsonProperty("data")
    public void setData(final T data) {
        this.data = data;
    }
    public String getSuccessMsg() {
        return this.successMsg;
    }

    @JsonProperty("success_msg")
    public void setSuccessMsg(final String successMsg) {
        this.successMsg = successMsg;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    @JsonProperty("error_msg")
    public void setErrorMsg(final String errorMsg) {
        this.errorMsg = errorMsg;
    }
    public SpdErrorResponse getSpdErrorResponse() {
        return this.spdErrorResponse;
    }

    @JsonProperty("error")
    public void setSpdErrorResponse(final SpdErrorResponse spdErrorResponse) {
        this.spdErrorResponse = spdErrorResponse;
    }
}