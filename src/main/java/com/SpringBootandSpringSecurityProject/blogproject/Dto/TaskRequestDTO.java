package com.SpringBootandSpringSecurityProject.blogproject.Dto;


import com.SpringBootandSpringSecurityProject.blogproject.payload.request.TaskCreateRequest;
import com.SpringBootandSpringSecurityProject.blogproject.entity.Task;
import com.SpringBootandSpringSecurityProject.blogproject.entity.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
public class TaskRequestDTO {

    private Task task=new Task();

    public TaskRequestDTO(TaskCreateRequest taskCreateRequest, User user){
        task.setTask_date(taskCreateRequest.getStart_date());
        task.setStart_time(taskCreateRequest.getStart_time());
        task.setStop_time(taskCreateRequest.getStop_time());
        task.setDescription(taskCreateRequest.getDescription());
        task.setUser(user);
    }



}
