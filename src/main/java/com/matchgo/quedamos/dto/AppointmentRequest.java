package com.matchgo.quedamos.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequest {

    @NotBlank
    private String title;

    private String description;

    @NotBlank
    private String location;

    @Future
    private LocalDateTime dateTime;

    @NotNull
    @PositiveOrZero
    private Double deposit;

    @NotNull
    private Long guestId;
}