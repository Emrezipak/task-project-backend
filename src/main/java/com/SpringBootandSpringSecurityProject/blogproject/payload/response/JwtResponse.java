package com.SpringBootandSpringSecurityProject.blogproject.payload.response;

import com.SpringBootandSpringSecurityProject.blogproject.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

    private User user;
    private String token;
    private String tokenType="Bearer";
    private Set<String> roles;


    public JwtResponse(User user, String token,Set<String> roles) {
        this.user = user;
        this.token = token;
        this.roles=roles;
    }

}
