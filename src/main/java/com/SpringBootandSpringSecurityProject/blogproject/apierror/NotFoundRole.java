package com.SpringBootandSpringSecurityProject.blogproject.apierror;

public class NotFoundRole extends RuntimeException {

    public NotFoundRole(String message){
        super(message);
    }
}
