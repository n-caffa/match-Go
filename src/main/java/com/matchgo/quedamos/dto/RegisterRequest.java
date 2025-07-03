package com.matchgo.quedamos.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String fullName;
    private String email;
    private String password;
    private String city;
    private String bio;
}