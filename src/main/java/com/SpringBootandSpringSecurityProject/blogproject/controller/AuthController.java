package com.SpringBootandSpringSecurityProject.blogproject.controller;

import com.SpringBootandSpringSecurityProject.blogproject.payload.request.LoginRequest;
import com.SpringBootandSpringSecurityProject.blogproject.payload.request.UserCreateRequest;
import com.SpringBootandSpringSecurityProject.blogproject.payload.response.UserJwtResponse;
import com.SpringBootandSpringSecurityProject.blogproject.payload.response.UserResponse;
import com.SpringBootandSpringSecurityProject.blogproject.security.CreateJwtToken;
import com.SpringBootandSpringSecurityProject.blogproject.security.UserDetailsImp;
import com.SpringBootandSpringSecurityProject.blogproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CreateJwtToken createJwtToken;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        Authentication authentication=authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token=createJwtToken.genarateJwtToken(authentication);
        UserDetailsImp user=(UserDetailsImp)authentication.getPrincipal();
        return ResponseEntity.ok(new UserJwtResponse(user.getUser(),token));
    }

    @PostMapping("/register")
    public UserResponse register(@Valid @RequestBody UserCreateRequest user){
        return userService.addUser(user);
    }

}
