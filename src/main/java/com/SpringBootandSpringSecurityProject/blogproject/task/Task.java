package com.SpringBootandSpringSecurityProject.blogproject.task;

import com.SpringBootandSpringSecurityProject.blogproject.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import javax.persistence.*;
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

    @NotNull
    @JsonFormat(pattern ="yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    private Date task_date;

    @NotNull
    @JsonFormat(pattern = "hh:mm a")
    private LocalTime start_time;

    @NotNull
    @JsonFormat(pattern = "hh:mm a")
    private LocalTime stop_time;

    @ManyToOne()
    @NotNull
    @JoinColumn(name="user_id")
    private User user;

    @NotEmpty
    @Size(min=4 ,max=255)
    private String description;
}
