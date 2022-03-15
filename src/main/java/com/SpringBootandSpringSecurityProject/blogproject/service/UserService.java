package com.SpringBootandSpringSecurityProject.blogproject.service;

import com.SpringBootandSpringSecurityProject.blogproject.Dto.UserDto;
import com.SpringBootandSpringSecurityProject.blogproject.entity.User;
import com.SpringBootandSpringSecurityProject.blogproject.payload.request.UserCreateRequest;
import com.SpringBootandSpringSecurityProject.blogproject.payload.response.UserResponse;
import com.SpringBootandSpringSecurityProject.blogproject.entity.Role;
import com.SpringBootandSpringSecurityProject.blogproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    @Value("${app.default.role}")
    private String defaultRole;


    public UserResponse addUser(UserCreateRequest userCreateRequest) {
        UserDto userRequestDTO=new UserDto(userCreateRequest);
        Set<Role> roleList=new HashSet<>();
        if(userCreateRequest.getRoles()!=null && userCreateRequest.getRoles().size()!=0){
            roleList=this.roleService.controlByRoleName(userCreateRequest.getRoles());
        }
        else{
            roleList=this.roleService.controlByRoleName(Stream.of(defaultRole).collect(Collectors.toSet()));
        }

        userRequestDTO.getUser().setRoles(roleList);
        User user=userRequestDTO.getUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new UserResponse("create User",HttpStatus.OK.value(),user);
    }

    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    public List<User> getByName(String name) {
        return this.userRepository.existsByName(name);
    }

    public UserResponse deleteUser(long id) {
        Optional<User> user=this.userRepository.findById(id);
        if(user.isPresent()){
            this.userRepository.deleteById(id);
            return new UserResponse("User successfully deleted");
        }
        return new UserResponse("deletion failed");
    }


    public User getByEmail(String email){
        return this.userRepository.getByEmail(email);
    }

    /*
    public UserResponse updateUser(long id, UserCreateRequest userCreateRequest){

        return userRepository.findById(id).map((user)->{
            user.setName(userCreateRequest.getName());
            user.setEmail(userCreateRequest.getEmail());
            user.setRoles(roleService.controlByRoleName(userCreateRequest.getRoles()));
            user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
            userRepository.save(user);
            return new UserResponse("update User", HttpStatus.OK.value(),user);
        }).orElseGet(()->{
            return new UserResponse("not found user",HttpStatus.NOT_FOUND.value());
        });
    }
     */


}
