package com.SpringBootandSpringSecurityProject.blogproject.ApiError;

public class NotFoundRole extends RuntimeException {

    public NotFoundRole(String message){
        super(message);
    }
}
