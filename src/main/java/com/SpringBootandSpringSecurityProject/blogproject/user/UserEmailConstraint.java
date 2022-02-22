package com.SpringBootandSpringSecurityProject.blogproject.user;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserEmailConstraint implements ConstraintValidator<UniqueEmail,String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !userRepository.existsByEmail(value);
    }
}
