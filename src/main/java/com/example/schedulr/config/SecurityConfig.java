package com.example.schedulr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults()) // Enable CORS
                .csrf().disable() // Disable CSRF for simplicity (only for development)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // allow all endpoints without auth
                );
        return http.build();
    }
}
