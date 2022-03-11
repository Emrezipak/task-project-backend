package com.SpringBootandSpringSecurityProject.blogproject.repository;

import com.SpringBootandSpringSecurityProject.blogproject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> getByRoleName(String name);
}
