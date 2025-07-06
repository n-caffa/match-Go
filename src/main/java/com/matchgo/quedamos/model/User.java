package com.matchgo.quedamos.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String city;
    private String bio;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    private boolean verified = false;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Reputation reputation;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<Appointment> createdAppointments = new ArrayList<>();

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<Appointment> receivedAppointments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Pledge> pledges = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}