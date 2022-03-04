package com.SpringBootandSpringSecurityProject.blogproject.util;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({  PARAMETER,LOCAL_VARIABLE })
@Retention(RUNTIME)
@AuthenticationPrincipal
public @interface CurrentUser {
}
