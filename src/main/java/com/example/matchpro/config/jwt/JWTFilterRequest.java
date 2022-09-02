package com.example.matchpro.config.jwt;

import com.example.matchpro.service.CustomUserDetailsService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * The JWT filter request.
 *
 * @author Alben Bustamante
 */
@Component
@RequiredArgsConstructor
public class JWTFilterRequest extends OncePerRequestFilter {
    private static final String PREFIX = "Bearer";
    private static final int BEGIN_INDEX = PREFIX.length() + 1;
    private final CustomUserDetailsService userDetailsService;
    private final JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final var authorizationHeader = request.getHeader("Authorization");

        if (isToken(authorizationHeader)) {
            final var token = authorizationHeader.substring(BEGIN_INDEX);
            final var username = jwtUtil.getUsername(token);

            if (isNotAuthenticated(username)) {
                final var userDetails = userDetailsService.loadUserByUsername(username);

                if (jwtUtil.isValid(userDetails, token)) {
                    final var authToken = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getUsername(), userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }

        filterChain.doFilter(request, response);
    }

    private boolean isToken(final String authorizationHeader) {
        return authorizationHeader != null && authorizationHeader.startsWith(PREFIX);
    }

    private boolean isNotAuthenticated(final String username) {
        return username != null && SecurityContextHolder.getContext().getAuthentication() == null;
    }
}
