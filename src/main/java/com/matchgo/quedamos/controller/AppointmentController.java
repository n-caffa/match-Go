package com.matchgo.quedamos.controller;

import com.matchgo.quedamos.dto.AppointmentRequest;
import com.matchgo.quedamos.model.Appointment;
import com.matchgo.quedamos.model.User;
import com.matchgo.quedamos.service.AppointmentService;
import com.matchgo.quedamos.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(
            @Valid @RequestBody AppointmentRequest request,
            @AuthenticationPrincipal User currentUser
    ) {
        Appointment createdAppointment = appointmentService.createAppointment(request, currentUser);
        return ResponseEntity.ok(createdAppointment);
    }
}