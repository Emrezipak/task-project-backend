package com.SpringBootandSpringSecurityProject.blogproject.payload.response;

import com.SpringBootandSpringSecurityProject.blogproject.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    private String message;

    private Integer httpCode;

    private User user;

    public UserResponse(String message) {
        this.message = message;
    }
    public UserResponse(String message,Integer httpCode) {
        this.message = message;
        this.httpCode=httpCode;
    }


}
