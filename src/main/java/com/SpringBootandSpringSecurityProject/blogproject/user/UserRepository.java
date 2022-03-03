package com.SpringBootandSpringSecurityProject.blogproject.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u From User u where u.name like %:name%")
    List<User> existsByName(@Param("name") String name);
    User getByEmail(String email);
    boolean existsByEmail(String email);
}
