package com.example.matchpro.service;

import com.example.matchpro.model.Role;
import com.example.matchpro.repository.IUserRepository;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The main {@link UserDetailsService} implementation.
 *
 * @author Alben Bustamante
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final IUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var user = repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with email: " + username + " not found"));

        final Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRoles().getName()));

        return new User(user.getEmail(), user.getPassword(), authorities);
    }
}
