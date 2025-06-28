package com.example.prova2.dto;

import com.example.prova2.model.UserRole;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class RegisterRequest {

    @NotBlank(message = "O username é obrigatório")
    private String username;

    @NotBlank(message = "A senha é obrigatória")
    private String password;

    @NotNull(message = "A role é obrigatória")
    private UserRole role = UserRole.USER;

}