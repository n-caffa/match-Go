package com.matchgo.quedamos.service;

import com.matchgo.quedamos.dto.LoginRequest;
import com.matchgo.quedamos.dto.RegisterRequest;
import com.matchgo.quedamos.model.User;
import com.matchgo.quedamos.repository.UserRepository;
import com.matchgo.quedamos.security.JwtService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public User register(@Valid RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("El email ya está en uso");
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setCity(request.getCity());
        user.setBio(request.getBio());

        User savedUser = userRepository.save(user);
        log.info("Usuario registrado: {}", savedUser.getEmail());

        return savedUser;
    }

    public String login(@Valid LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Email o contraseña incorrectos"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Email o contraseña incorrectos");
        }

        String token = jwtService.generateToken(String.valueOf(user));
        log.info("Login exitoso para: {}", user.getEmail());

        return token;
    }
}