package com.SpringBootandSpringSecurityProject.blogproject.apierror;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NotFoundRole.class)
    public ApiError handlerRoleNotFoundException(){
        return new ApiError("not found role",500,"auth/users");
    }
}
