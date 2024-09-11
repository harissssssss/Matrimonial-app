package com.matrimonial.matrimonialapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for development
                .authorizeHttpRequests((requests) -> requests
                        .anyRequest().permitAll()  // Allow all requests without authentication
                );
        //http
        //            .csrf(csrf -> csrf.disable())  // Disable CSRF protection (if needed)
        //            .authorizeHttpRequests((requests) -> requests
        //                .requestMatchers("/api/public/**").permitAll()  // Public URLs accessible without authentication
        //                .requestMatchers("/api/admin/**").hasRole("ADMIN")  // URLs restricted to users with ADMIN role
        //                .anyRequest().authenticated()  // All other requests require authentication
        //            );

        return http.build();
    }
}
