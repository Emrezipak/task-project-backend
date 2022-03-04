package com.SpringBootandSpringSecurityProject.blogproject.entity;

import com.SpringBootandSpringSecurityProject.blogproject.entity.Role;
import com.SpringBootandSpringSecurityProject.blogproject.entity.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min=4)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Task> tasks;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role"
    ,joinColumns =@JoinColumn(name="user_id")
    ,inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles;
}
