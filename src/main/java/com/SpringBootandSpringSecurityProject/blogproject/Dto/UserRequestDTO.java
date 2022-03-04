package com.SpringBootandSpringSecurityProject.blogproject.Dto;

import com.SpringBootandSpringSecurityProject.blogproject.payload.request.UserCreateRequest;
import com.SpringBootandSpringSecurityProject.blogproject.entity.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
public class UserRequestDTO {

    private User user=new User();

    public UserRequestDTO(UserCreateRequest userCreateRequest){
        user.setName(userCreateRequest.getName());
        user.setEmail(userCreateRequest.getEmail());
        user.setPassword(userCreateRequest.getPassword());
    }

}
