package com.SpringBootandSpringSecurityProject.blogproject.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.Date;
@Data
@ToString
@RequiredArgsConstructor
public class TaskCreateRequest {


    @NotNull
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date start_date;

    @NotNull
    @JsonFormat(pattern = "HH:mm")
    private LocalTime start_time;

    @NotNull
    @JsonFormat(pattern = "HH:mm")
    private LocalTime stop_time;

    @NotNull
    private String userEmail;

    @NotEmpty
    @Size(min=4)
    private String description;

}
