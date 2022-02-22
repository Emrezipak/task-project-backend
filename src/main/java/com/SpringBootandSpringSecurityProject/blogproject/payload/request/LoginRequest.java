package com.SpringBootandSpringSecurityProject.blogproject.payload.request;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
public class LoginRequest {

    private String email;

    private String password;

}
