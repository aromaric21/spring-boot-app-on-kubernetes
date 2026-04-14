package com.anr.book_management.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // désactive CSRF pour Postman
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll() // autorise toutes les requêtes API
                .anyRequest().authenticated()
                );
        return http.build();
    }
}
