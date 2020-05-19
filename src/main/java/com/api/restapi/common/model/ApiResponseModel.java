package com.api.restapi.common.model;

import static com.api.restapi.common.ApiCustomStatus.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class ApiResponseModel<T> {
    private boolean success;
    private int error_code;
    private String error_message;
    private T data;

    public ApiResponseModel (T data) {
        this(true, REQUEST_SUCCESS.code(), REQUEST_SUCCESS.message(), data);
    }

    public ApiResponseModel(boolean success, int error_code, String error_message) {
        this(success, error_code, error_message, null);
    }

    public ApiResponseModel(boolean success, int error_code, String error_message, T data) {
        this.success = success;
        this.error_code = error_code;
        this.error_message = error_message;
        this.data = data;
    }
}
