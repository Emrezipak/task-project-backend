package com.SpringBootandSpringSecurityProject.blogproject.task;

import com.SpringBootandSpringSecurityProject.blogproject.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue
    private long id;

    @Temporal(value = TemporalType.DATE)
    private Date task_date;

    private LocalTime start_time;

    private LocalTime stop_time;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;

    @Lob
    private String description;
}
