package com.SpringBootandSpringSecurityProject.blogproject.controller;

import com.SpringBootandSpringSecurityProject.blogproject.entity.User;
import com.SpringBootandSpringSecurityProject.blogproject.payload.request.LoginRequest;
import com.SpringBootandSpringSecurityProject.blogproject.payload.request.UserCreateRequest;
import com.SpringBootandSpringSecurityProject.blogproject.payload.response.UserJwtResponse;
import com.SpringBootandSpringSecurityProject.blogproject.payload.response.UserResponse;
import com.SpringBootandSpringSecurityProject.blogproject.security.CreateJwtToken;
import com.SpringBootandSpringSecurityProject.blogproject.security.UserDetailsImp;
import com.SpringBootandSpringSecurityProject.blogproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")
    public List<User> getAllUser(){
        return this.userService.getAllUser();
    }

    @GetMapping("/getByName")
    @PreAuthorize("hasAuthority('Admin')")
    public List<User> getByName(@RequestParam String name){
        return this.userService.getByName(name);
    }

    @GetMapping("/getByEmail")
    @PreAuthorize("hasAuthority('Admin')")
    public User getByEmail(@RequestParam String email){
        return this.userService.getByEmail(email);
    }

    @DeleteMapping("/deleteUser/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public UserResponse deleteUser(@PathVariable long id){
       return this.userService.deleteUser(id);
    }

    @PutMapping("/updateUser/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public UserResponse updateUser(@PathVariable long id, @RequestBody UserCreateRequest userCreateRequest){
        return userService.updateUser(id,userCreateRequest);
    }

}
