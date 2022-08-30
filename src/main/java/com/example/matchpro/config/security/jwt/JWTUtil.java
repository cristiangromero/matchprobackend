package com.example.matchpro.config.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * The utils for the JWT configuration.
 *
 * @author Alben Bustamante
 */
@Component
public class JWTUtil {
    private static final String ICE_CREAM = "295A4F84E9D224";
    private static final int TIME_EXPIRATION = 1000 * 60 * 20;

    /**
     * @param token the JWT.
     * @return the {@link Claims}
     */
    private Claims getClaims(final String token) {
        return Jwts.parserBuilder()
                .setSigningKey(ICE_CREAM.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * @param token the JWT.
     * @return the JWT subject.
     */
    public String getUsername(final String token) {
        return getClaims(token).getSubject();
    }

    /**
     * @param token the JWT.
     * @return {@code true} if the JWT is expired.
     */
    public boolean isExpired(final String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    /**
     * @param userDetails the {@link UserDetails}
     * @param token the JWT.
     * @return {@code true} if the JWT is valid.
     */
    public boolean isValid(final UserDetails userDetails, final String token) {
        return getUsername(token).equals(userDetails.getUsername()) && !isExpired(token);
    }

    /**
     * @param userDetails the {@link UserDetails}
     * @return the JWT.
     */
    public String generateToken(final UserDetails userDetails) {
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setSubject(userDetails.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + TIME_EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, ICE_CREAM)
                .compact();
    }

}
