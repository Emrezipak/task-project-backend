package com.SpringBootandSpringSecurityProject.blogproject.payload.response;

import com.SpringBootandSpringSecurityProject.blogproject.entity.User;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserJwtResponse {

    private User user;
    private String jwtToken;
    private String tokenType="Bearer";


    public UserJwtResponse(User user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }
}
