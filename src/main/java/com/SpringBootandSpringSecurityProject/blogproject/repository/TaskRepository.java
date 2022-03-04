package com.SpringBootandSpringSecurityProject.blogproject.repository;

import com.SpringBootandSpringSecurityProject.blogproject.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query("from Task t where t.user.email like %:email%")
    List<Task> getByUser_Email(@Param("email") String email);
}
