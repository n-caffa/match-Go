package com.matchgo.quedamos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pledges")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pledge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    private boolean refunded = false;

    @ManyToOne
    private User user;

    @OneToOne
    private Appointment appointment;
}
