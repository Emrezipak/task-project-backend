package com.SpringBootandSpringSecurityProject.blogproject.controller;

import com.SpringBootandSpringSecurityProject.blogproject.entity.Task;
import com.SpringBootandSpringSecurityProject.blogproject.payload.request.TaskCreateRequest;
import com.SpringBootandSpringSecurityProject.blogproject.repository.TaskRepository;
import com.SpringBootandSpringSecurityProject.blogproject.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    private static final Logger log= LoggerFactory.getLogger(TaskController.class);

    @PostMapping("/addTask")
    public ResponseEntity<?> addTask(@Valid @RequestBody TaskCreateRequest task){
            log.info(task.toString());
            return ResponseEntity.ok(this.taskService.addTask(task));
    }
    @GetMapping("/getAllTask")
    public List<Task> getAllTask(){
        return this.taskService.getAllTask();
    }

    @PutMapping("/updateTask")
    public Task updateTask(@RequestBody Task task){
        return this.taskService.updateTask(task);
    }

    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable long id){
       return ResponseEntity.ok(this.taskService.deleteTask(id));
    }

    @GetMapping("/getTaskByUser")
    public List<Task> getByUserTask(@RequestParam String email){
        return this.taskService.getByUserTask(email);
    }
}
