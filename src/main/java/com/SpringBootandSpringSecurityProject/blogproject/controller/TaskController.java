package com.SpringBootandSpringSecurityProject.blogproject.controller;

import com.SpringBootandSpringSecurityProject.blogproject.entity.Task;
import com.SpringBootandSpringSecurityProject.blogproject.payload.request.TaskCreateRequest;
import com.SpringBootandSpringSecurityProject.blogproject.payload.response.TaskResponse;
import com.SpringBootandSpringSecurityProject.blogproject.repository.TaskRepository;
import com.SpringBootandSpringSecurityProject.blogproject.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/addTask")
    public ResponseEntity<?> addTask(@Valid @RequestBody TaskCreateRequest task){
            return ResponseEntity.ok(this.taskService.addTask(task));
    }
    //@PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/getAllTask")
    public List<Task> getAllTask(){
         return this.taskService.getAllTask();
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PutMapping("/updateTask")
    public Task updateTask(@RequestBody Task task){
        return this.taskService.updateTask(task);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable long id){
       return ResponseEntity.ok(this.taskService.deleteTask(id));
    }

    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")
    @GetMapping("/getTaskByUser")
    public List<Task> getByUserTask(@RequestParam String email){
        return this.taskService.getTaskByUserEmail(email);
    }
}
