package com.SpringBootandSpringSecurityProject.blogproject.payload.request;

import com.SpringBootandSpringSecurityProject.blogproject.user.UniqueEmail;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@RequiredArgsConstructor
public class UserCreateRequest {

    @NotEmpty
    @Size(min=2,max=100)
    private String name;
    @NotEmpty
    @Email()
    @UniqueEmail
    private String email;
    @NotEmpty
    @Size(min=4,max = 100)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;
}
