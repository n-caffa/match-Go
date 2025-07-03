package com.matchgo.quedamos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reputations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reputation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score = 0;

    private int successfulAppointments = 0;

    private int missedAppointments = 0;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}