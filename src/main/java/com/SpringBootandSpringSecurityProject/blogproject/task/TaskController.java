package com.SpringBootandSpringSecurityProject.blogproject.task;

import com.SpringBootandSpringSecurityProject.blogproject.payload.request.TaskCreateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Task addTask(@RequestBody TaskCreateRequest task){
            log.info(task.toString());
            return this.taskService.addTask(task);
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
    public void deleteTask(@PathVariable long id){
        this.taskService.deleteTask(id);
    }

    @GetMapping("/getByUserTask")
    public List<Task> getByUserTask(@RequestParam String email){
        return this.taskService.getByUserTask(email);
    }
}
