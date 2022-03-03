package com.SpringBootandSpringSecurityProject.blogproject.payload.response;

import com.SpringBootandSpringSecurityProject.blogproject.entity.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse {

    private String message;
    private Role roles;

    public RoleResponse(String message) {
        this.message = message;
    }
}
