package com.example.prova2.service;

import com.example.prova2.model.User;
import com.example.prova2.model.UserRole;
import com.example.prova2.repository.UserRepository;
import com.example.prova2.dto.RegisterRequest;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService; 

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    /**
     * Autentica um usuário e, se bem-sucedido, gera e retorna um token JWT.
     * @param username Nome de usuário.
     * @param password Senha em texto claro.
     * @return O token JWT.
     * @throws BadCredentialsException Se as credenciais forem inválidas.
     */
    public String authenticateUserAndGenerateToken(String username, String rawPassword) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new BadCredentialsException("Usuário não encontrado."));

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new BadCredentialsException("Senha incorreta.");
        }

        return jwtService.generateToken(user.getUsername(), user.getRole().name());
    }

    public void register(RegisterRequest request) {
    if (userRepository.findByUsername(request.getUsername()).isPresent()) {
        throw new IllegalArgumentException("Nome de usuário já está em uso.");
    }

    User user = new User();
    user.setUsername(request.getUsername());
    user.setPassword(passwordEncoder.encode(request.getPassword()));

    UserRole role = request.getRole() != null ? request.getRole() : UserRole.USER;

    user.setRole(role);

    userRepository.save(user);
   }
}