package com.matchgo.quedamos.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;

        private String description;

        private String location;

        private LocalDateTime dateTime;

        private Double deposit;

        @Enumerated(EnumType.STRING)
        private AppointmentStatus status;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "creator_id", nullable = false)
        private User creator;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "guest_id", nullable = false)
        private User guest;

    private boolean checkedInCreator;
    private boolean checkedInReceiver;

    }

