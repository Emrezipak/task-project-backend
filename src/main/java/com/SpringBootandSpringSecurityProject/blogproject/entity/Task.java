package com.SpringBootandSpringSecurityProject.blogproject.entity;

import com.SpringBootandSpringSecurityProject.blogproject.entity.User;
import lombok.Data;


import javax.persistence.*;
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
