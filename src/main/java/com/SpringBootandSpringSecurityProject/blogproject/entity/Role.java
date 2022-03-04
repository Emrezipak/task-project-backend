package com.SpringBootandSpringSecurityProject.blogproject.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String roleName;
}
