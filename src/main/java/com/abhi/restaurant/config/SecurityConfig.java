package com.abhi.restaurant.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    // password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // main security config
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // disable csrf
            .csrf(csrf -> csrf.disable())

            // JWT → no session
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // authorize requests
            .authorizeHttpRequests(auth -> auth

                // 🔓 PUBLIC APIs
                .requestMatchers("/api/auth/**").permitAll()

                // 🔓 OPTIONAL (if you want open APIs)
                .requestMatchers("/api/menu/**").permitAll()

                // 🔒 PROTECTED APIs
                .requestMatchers("/api/orders/**").hasAnyRole("ADMIN", "STAFF")
                .requestMatchers("/api/order-items/**").hasAnyRole("ADMIN", "STAFF")
                .requestMatchers("/api/bills/**").hasAnyRole("ADMIN", "STAFF")
                .requestMatchers("/api/payments/**").hasAnyRole("ADMIN", "STAFF")
                .requestMatchers("/api/customers/**").hasAnyRole("ADMIN", "STAFF")

                // 🔒 ADMIN ONLY
                .requestMatchers("/api/admin/**").hasRole("ADMIN")

                // all other requests
                .anyRequest().authenticated()
            )

            // add JWT filter
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

            // disable basic auth
            .httpBasic(basic -> basic.disable());

        return http.build();
    }
}