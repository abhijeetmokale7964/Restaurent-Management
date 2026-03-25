package com.abhi.restaurant.controller;
import com.abhi.restaurant.dto.*;
import com.abhi.restaurant.model.User;
import com.abhi.restaurant.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // register
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return authService.register(user);
    }

    // login
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}