package com.matchgo.quedamos.service;

import com.matchgo.quedamos.dto.AppointmentRequest;
import com.matchgo.quedamos.model.Appointment;
import com.matchgo.quedamos.model.User;
import com.matchgo.quedamos.repository.AppointmentRepository;
import com.matchgo.quedamos.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;

    public Appointment createAppointment(AppointmentRequest request, User creator) {
        User guest = userRepository.findById(request.getGuestId())
                .orElseThrow(() -> new EntityNotFoundException("Guest not found"));

        Appointment appointment = new Appointment();
        appointment.setTitle(request.getTitle());
        appointment.setDescription(request.getDescription());
        appointment.setLocation(request.getLocation());
        appointment.setDateTime(request.getDateTime());
        appointment.setDeposit(request.getDeposit());
        appointment.setCreator(creator);
        appointment.setGuest(guest);
        appointment.setStatus(AppointmentStatus.PENDING);

        return appointmentRepository.save(appointment);
    }
}