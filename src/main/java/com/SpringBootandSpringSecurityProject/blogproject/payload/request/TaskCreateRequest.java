package com.SpringBootandSpringSecurityProject.blogproject.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.time.LocalTime;
import java.util.Date;
@Data
@ToString
@RequiredArgsConstructor
public class TaskCreateRequest {

    private Date date;

    @JsonFormat(pattern = "hh:mm a")
    private LocalTime start;

    @JsonFormat(pattern = "hh:mm a")
    private LocalTime stop;

    private String user_email;

    private String description;

}
