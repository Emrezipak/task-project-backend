package com.SpringBootandSpringSecurityProject.blogproject.security;

import com.SpringBootandSpringSecurityProject.blogproject.user.User;
import com.SpringBootandSpringSecurityProject.blogproject.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user=this.userRepository.getByEmail(username);
        if(user!=null){
            return new UserDetailsImp(user);
        }
        throw new UsernameNotFoundException("not found user");
    }
}
