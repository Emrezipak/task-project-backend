package com.SpringBootandSpringSecurityProject.blogproject.ApiError;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private String message;

    private Integer statusCode;

    private String path;

    private long timeStamp= new Date().getTime();

    private Map<String,String> validations;

    public ApiError(String message, Integer statusCode, String path) {
        this.message = message;
        this.statusCode = statusCode;
        this.path = path;
    }
}
