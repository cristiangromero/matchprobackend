package com.example.matchpro.service;

import com.example.matchpro.model.Role;
import com.example.matchpro.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService extends CrudService<Role> implements IRoleService{

    private final RoleRepository repository;

    @Override
    protected CrudRepository<Role, Long> repository() {
        return repository;
    }

    @Override
    public Optional<Role> update(long id, Role role) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        role.setRoleId(id);

        return Optional.of(repository.save(role));
    }

}