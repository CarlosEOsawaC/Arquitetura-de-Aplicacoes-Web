package com.example.prova2.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    @NotBlank(message = "O nome de usuário é obrigatório.")
    private String username;

    @NotBlank(message = "A senha é obrigatória.")
    private String password;
}