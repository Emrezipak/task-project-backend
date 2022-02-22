package com.SpringBootandSpringSecurityProject.blogproject.Dto;


import com.SpringBootandSpringSecurityProject.blogproject.payload.request.TaskCreateRequest;
import com.SpringBootandSpringSecurityProject.blogproject.task.Task;
import com.SpringBootandSpringSecurityProject.blogproject.user.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
public class TaskRequestDTO {

    private Task task=new Task();

    public TaskRequestDTO(TaskCreateRequest taskCreateRequest, User user){
        task.setTask_date(taskCreateRequest.getDate());
        task.setStart_time(taskCreateRequest.getStart());
        task.setStop_time(taskCreateRequest.getStop());
        task.setDescription(taskCreateRequest.getDescription());
        task.setUser(user);
    }



}
