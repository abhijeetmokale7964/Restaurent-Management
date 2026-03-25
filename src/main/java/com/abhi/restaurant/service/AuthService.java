package com.abhi.restaurant.service;

import com.abhi.restaurant.dto.*;
import com.abhi.restaurant.model.User;
import com.abhi.restaurant.repository.UserRepository;
import com.abhi.restaurant.config.JwtUtil;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    // register
    public String register(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return "User registered successfully";
    }

    // login
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token, token);
    }
}