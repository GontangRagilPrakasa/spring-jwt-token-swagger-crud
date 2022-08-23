package com.tutorial.jwtauthentication.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public ResponseUtil() {
    }

    public static <T> ResponseEntity<Object> build(Boolean status, int statusCode, String message,
                                                   T data, HttpStatus httpStatus)
    {
        return  new ResponseEntity<>(returnResponse(status, statusCode, message, data), httpStatus);
    }

    private static <T>ApiResponse<T> returnResponse(Boolean status, int statusCode, String message,  T data) {
        ApiResponse response = new ApiResponse();
        response.setStatus(status);
        response.setMessage(message);
        response.setStatusCode(statusCode);
        response.setData(data);

        return  response;
    }
}
