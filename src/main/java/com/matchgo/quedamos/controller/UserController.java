package com.matchgo.quedamos.controller;

import com.matchgo.quedamos.dto.LoginRequest;
import com.matchgo.quedamos.dto.RegisterRequest;
import com.matchgo.quedamos.dto.UserResponse;
import com.matchgo.quedamos.model.User;
import com.matchgo.quedamos.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterRequest request) {
        User user = userService.register(request);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid  @RequestBody LoginRequest request) {
        String token = userService.login(request);
        return ResponseEntity.ok().body(Map.of("token", token));
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getCurrentUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(new UserResponse(user));
    }


}