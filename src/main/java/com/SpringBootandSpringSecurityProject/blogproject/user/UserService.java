package com.SpringBootandSpringSecurityProject.blogproject.user;

import com.SpringBootandSpringSecurityProject.blogproject.Dto.UserRequestDTO;
import com.SpringBootandSpringSecurityProject.blogproject.payload.request.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User addUser(UserCreateRequest userCreateRequest) {
        UserRequestDTO userRequestDTO=new UserRequestDTO(userCreateRequest);
        User user=userRequestDTO.getUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }
    /*
    public User createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

     */

    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    public List<User> getByName(String name) {
        return this.userRepository.existsByName(name);
    }

    public void deleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public User getByEmail(String email){
        return this.userRepository.getByEmail(email);
    }
}
