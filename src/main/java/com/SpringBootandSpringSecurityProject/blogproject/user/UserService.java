package com.SpringBootandSpringSecurityProject.blogproject.user;

import com.SpringBootandSpringSecurityProject.blogproject.ApiError.NotFoundRole;
import com.SpringBootandSpringSecurityProject.blogproject.Dto.UserRequestDTO;
import com.SpringBootandSpringSecurityProject.blogproject.payload.request.UserCreateRequest;
import com.SpringBootandSpringSecurityProject.blogproject.payload.response.RoleResponse;
import com.SpringBootandSpringSecurityProject.blogproject.payload.response.TaskResponse;
import com.SpringBootandSpringSecurityProject.blogproject.payload.response.UserResponse;
import com.SpringBootandSpringSecurityProject.blogproject.role.Role;
import com.SpringBootandSpringSecurityProject.blogproject.role.RoleRepository;
import com.SpringBootandSpringSecurityProject.blogproject.role.RoleService;
import com.SpringBootandSpringSecurityProject.blogproject.task.Task;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;


    public UserResponse addUser(UserCreateRequest userCreateRequest) {

        UserRequestDTO userRequestDTO=new UserRequestDTO(userCreateRequest);
        Set<Role> roleList=this.controlByRoleName(userCreateRequest.getRoles());
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
            user.setRoles(controlByRoleName(userCreateRequest.getRoles()));
            user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
            userRepository.save(user);
            return new UserResponse("update User", HttpStatus.OK.value(),user);
        }).orElseGet(()->{
            return new UserResponse("not found user",HttpStatus.NOT_FOUND.value());
        });
    }

    private Set<Role> controlByRoleName(Set<String> roles){
        Set<Role> roleList=new HashSet<>();
        for(String role:roles){
            Role getRole=roleService.getRoleByRoleName(role);
            if(getRole ==null){
                 throw new NotFoundRole("not found role");
            }
            roleList.add(getRole);
        }

        return roleList;

        /*
        roles.forEach((role)->{
            Role getRole=roleService.getRoleByRoleName(role);
            if(getRole!=null){
                roleList.add(getRole);
            }
        });

         */

    }
}
