package com.SpringBootandSpringSecurityProject.blogproject.task;

import com.SpringBootandSpringSecurityProject.blogproject.Dto.TaskRequestDTO;
import com.SpringBootandSpringSecurityProject.blogproject.payload.request.TaskCreateRequest;
import com.SpringBootandSpringSecurityProject.blogproject.user.User;
import com.SpringBootandSpringSecurityProject.blogproject.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public Task addTask(TaskCreateRequest taskRequest) {
        User user=this.userService.getByEmail(taskRequest.getUser_email().trim());
        if(user!=null){
            Task task=this.getTaskResultDto(taskRequest,user);
            return this.taskRepository.save(task);

        }
       throw new NullPointerException("User bulunamadı");
    }


    public List<Task> getAllTask() {
        return this.taskRepository.findAll();
    }

    public Task updateTask(Task newTask) {
        return this.taskRepository.save(newTask);
    }

    public void deleteTask(long id) {
        this.taskRepository.deleteById(id);
    }

    public List<Task> getByUserTask(String email){
        return this.taskRepository.getByUser_Email(email);
    }

    private Task getTaskResultDto(TaskCreateRequest taskCreateRequest,User user){
        TaskRequestDTO taskRequestDTO=new TaskRequestDTO(taskCreateRequest,user);
        return taskRequestDTO.getTask();
    }

}
