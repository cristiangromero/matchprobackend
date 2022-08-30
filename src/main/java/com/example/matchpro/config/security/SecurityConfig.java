package com.example.matchpro.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Here is the main configuration for the security.
 *
 * @author Alben Bustamante
 */
@Configuration
public class SecurityConfig {

    /**
     * @return a {@link BCryptPasswordEncoder} by default.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
