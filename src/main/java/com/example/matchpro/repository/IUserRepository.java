package com.example.matchpro.repository;

import com.example.matchpro.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The {@link User} repository.
 *
 * @author Alben Bustamante
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    /**
     * Find a {@link User} by an email.
     *
     * @param email the email to search.
     * @return an optional of the {@link User} found.
     */
    Optional<User> findByEmail(String email);

}
