package com.SpringBootandSpringSecurityProject.blogproject.service;

import com.SpringBootandSpringSecurityProject.blogproject.Dto.UserRequestDTO;
import com.SpringBootandSpringSecurityProject.blogproject.entity.User;
import com.SpringBootandSpringSecurityProject.blogproject.payload.request.UserCreateRequest;
import com.SpringBootandSpringSecurityProject.blogproject.payload.response.UserResponse;
import com.SpringBootandSpringSecurityProject.blogproject.entity.Role;
import com.SpringBootandSpringSecurityProject.blogproject.repository.UserRepository;
import com.SpringBootandSpringSecurityProject.blogproject.service.RoleService;
import org.hibernate.validator.internal.util.CollectionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    @Value("${userservice.user.role}")
    private String role_user;

    public UserResponse addUser(UserCreateRequest userCreateRequest) {
        UserRequestDTO userRequestDTO=new UserRequestDTO(userCreateRequest);
        Set<Role> roleList=new HashSet<>();
        if(userCreateRequest.getRoles()!=null && userCreateRequest.getRoles().size()!=0){
            roleList=this.roleService.controlByRoleName(userCreateRequest.getRoles());
        }
        else{
            //Set<String> şeklinde de gönderilebilir...
             roleList=this.roleService.controlByRoleName(CollectionHelper.asSet(role_user));
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



        /*
        roles.forEach((role)->{
            Role getRole=roleService.getRoleByRoleName(role);
            if(getRole!=null){
                roleList.add(getRole);
            }
        });

         */


}
