package com.example.matchpro.service;

import com.example.matchpro.model.User;
import com.example.matchpro.repository.IUserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * The {@link IUserService} implementation.
 *
 * @author Alben Bustamante
 */
@Service
@RequiredArgsConstructor
public class UserService extends CrudService<User> implements IUserService {

    private final IUserRepository repository;
    private final PasswordEncoder encoder;

    @Override
    protected CrudRepository<User, Long> repository() {
        return repository;
    }

    @Override
    public User create(User user) {
        user.setPassword(encoder.encode(user.getPassword()));

        return repository.save(user);
    }

    @Override
    public Optional<User> update(long id, User user) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        user.setUserId(id);
        user.setPassword(encoder.encode(user.getPassword()));

        return Optional.of(repository.save(user));
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return repository.findByEmail(email);
    }
}
