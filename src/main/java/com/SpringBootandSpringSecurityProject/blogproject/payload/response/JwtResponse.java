package com.SpringBootandSpringSecurityProject.blogproject.payload.response;

import com.SpringBootandSpringSecurityProject.blogproject.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

    private User user;
    private String token;
    private String tokenType="Bearer";

    public JwtResponse(User user, String token) {
        this.user = user;
        this.token = token;
    }
}
