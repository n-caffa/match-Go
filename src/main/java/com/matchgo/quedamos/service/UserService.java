package com.matchgo.quedamos.service;

import com.matchgo.quedamos.dto.RegisterRequest;
import com.matchgo.quedamos.model.Role;
import com.matchgo.quedamos.model.User;
import com.matchgo.quedamos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email ya registrado.");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .city(request.getCity())
                .bio(request.getBio())
                .role(Role.USER)
                .build();

        return userRepository.save(user);
    }
}