package com.example.matchpro.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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

    /**
     * @param authConfig the {@link AuthenticationConfiguration}
     * @return the {@link AuthenticationManager} from the configuration.
     * @throws Exception if an error occurs.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    /**
     * Override the main security.
     *
     * @param http the {@link HttpSecurity}
     * @return the {@link SecurityFilterChain} configured.
     * @throws Exception if an error occurs.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/v2/api-docs", "/configuration/ui", "/configuration/security").permitAll()
                .antMatchers("/swagger-ui/**", "/swagger-resources/**", "/webjars/**").permitAll()
                .and()
                .build();
    }

}
