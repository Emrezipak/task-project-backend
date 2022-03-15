package com.SpringBootandSpringSecurityProject.blogproject.controller;

import com.SpringBootandSpringSecurityProject.blogproject.entity.User;
import com.SpringBootandSpringSecurityProject.blogproject.payload.request.UserCreateRequest;
import com.SpringBootandSpringSecurityProject.blogproject.payload.response.UserResponse;
import com.SpringBootandSpringSecurityProject.blogproject.security.UserDetailsImp;
import com.SpringBootandSpringSecurityProject.blogproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //@PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/getAll")
    public List<User> getAllUser(){
        return this.userService.getAllUser();
    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/getByName")
    public List<User> getByName(@RequestParam String name){
        return this.userService.getByName(name);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/getByEmail")
    public User getByEmail(@RequestParam String email){
        return this.userService.getByEmail(email);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @DeleteMapping("/deleteUser/{id}")
    public UserResponse deleteUser(@PathVariable long id){
       return this.userService.deleteUser(id);
    }

    /*
    @PreAuthorize("hasAuthority('Admin')")
    @PutMapping("/updateUser/{id}")
    public UserResponse updateUser(@PathVariable long id, @RequestBody UserCreateRequest userCreateRequest){
        return userService.updateUser(id,userCreateRequest);
    }
     */

}
