package com.SpringBootandSpringSecurityProject.blogproject.service;

import com.SpringBootandSpringSecurityProject.blogproject.Dto.TaskDto;
import com.SpringBootandSpringSecurityProject.blogproject.entity.Task;
import com.SpringBootandSpringSecurityProject.blogproject.payload.request.TaskCreateRequest;
import com.SpringBootandSpringSecurityProject.blogproject.payload.response.TaskResponse;
import com.SpringBootandSpringSecurityProject.blogproject.repository.TaskRepository;
import com.SpringBootandSpringSecurityProject.blogproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public TaskResponse addTask(TaskCreateRequest taskRequest) {
        User user=this.userService.getByEmail(taskRequest.getUserEmail().trim());
        if(user!=null){
            Task task=this.getTaskResultDto(taskRequest,user);
             this.taskRepository.save(task);
             return new TaskResponse("task successfully added",task);
        }
        return new TaskResponse("not found user");
    }


    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Task updateTask(Task newTask) {
        return this.taskRepository.save(newTask);
    }

    public TaskResponse deleteTask(long id) {
        Optional<Task> task=this.taskRepository.findById(id);
        if(task.isPresent()){
            this.taskRepository.deleteById(id);
            return new TaskResponse("task successfully deleted");
        }
        return new TaskResponse("deletion failed");
    }

    public List<Task> getTaskByUserEmail(String email){
        return this.taskRepository.getByUser_Email(email);
    }

    private Task getTaskResultDto(TaskCreateRequest taskCreateRequest,User user){
        TaskDto taskRequestDTO=new TaskDto(taskCreateRequest,user);
        return taskRequestDTO.getTask();
    }

}
