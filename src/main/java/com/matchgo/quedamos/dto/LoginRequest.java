package com.matchgo.quedamos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @Email(message = "El email no tiene un formato válido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
}