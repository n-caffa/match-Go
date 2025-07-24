package com.matchgo.quedamos.dto;

import com.matchgo.quedamos.model.AppointmentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponse {
    private Long id;
    private String title;
    private String description;
    private String location;
    private LocalDateTime dateTime;
    private Double deposit;
    private AppointmentStatus status;
    private String creatorName;
    private String guestName;
}
