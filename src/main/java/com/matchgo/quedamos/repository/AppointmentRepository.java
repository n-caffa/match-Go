package com.matchgo.quedamos.repository;


import com.matchgo.quedamos.model.Appointment;
import com.matchgo.quedamos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByCreator(User creator);
    List<Appointment> findByGuest(User guest);
}