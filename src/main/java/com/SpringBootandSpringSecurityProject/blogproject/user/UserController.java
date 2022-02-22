package com.SpringBootandSpringSecurityProject.blogproject.user;

import com.SpringBootandSpringSecurityProject.blogproject.ApiError.ApiError;
import com.SpringBootandSpringSecurityProject.blogproject.payload.request.LoginRequest;
import com.SpringBootandSpringSecurityProject.blogproject.payload.request.UserCreateRequest;
import com.SpringBootandSpringSecurityProject.blogproject.security.UserDetailsImp;
import com.SpringBootandSpringSecurityProject.blogproject.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(Authentication authentication){
        UserDetailsImp user=(UserDetailsImp)authentication.getPrincipal();
        return ResponseEntity.ok(user.getUser());
    }

    @PostMapping("/register")
    public User register(@Valid @RequestBody UserCreateRequest user){
        return userService.addUser(user);
    }

    @GetMapping("/getAll")
    public List<User> getAllUser(){
        return this.userService.getAllUser();
    }

    @GetMapping("/getByName")
    public List<User> getByName(@RequestParam String name){
        return this.userService.getByName(name);
    }

    @GetMapping("/getByEmail")
    public User getByEmail(@RequestParam String email){
        return this.userService.getByEmail(email);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable long id){
        this.userService.deleteUser(id);
    }

}
