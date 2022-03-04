package com.SpringBootandSpringSecurityProject.blogproject.payload.response;

import com.SpringBootandSpringSecurityProject.blogproject.entity.Task;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskResponse {

    private String message;
    private Task task;

    public TaskResponse(String message){
        this.message=message;
    }

}
