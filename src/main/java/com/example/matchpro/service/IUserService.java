package com.example.matchpro.service;

import com.example.matchpro.model.User;
import java.util.Optional;

/**
 * The {@link User} service template.
 *
 * @author Alben Bustamante
 */
public interface IUserService extends ICrudService<User> {

    /**
     * Get an user by the email.
     *
     * @param email the email to search.
     * @return an optional of the user found.
     */
    Optional<User> getByEmail(String email);

}
