package com.SpringBootandSpringSecurityProject.blogproject.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy ={UserEmailConstraint.class})
public @interface UniqueEmail {
    String message() default "this user is exist already";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
