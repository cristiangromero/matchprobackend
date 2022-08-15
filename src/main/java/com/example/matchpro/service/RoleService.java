package com.example.matchpro.service;

import com.example.matchpro.model.Role;
import com.example.matchpro.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Autowired
    public RoleRepository roleRepo;

    @Override
    public List<Role> listRole() {
        return roleRepo.findAll();
    }

    @Override
    public void newRole(Role role) {
        roleRepo.save(role);
    }

    @Override
    public void deleteRole(Role role) {
        roleRepo.delete(role);
    }

    @Override
    public Role findRole(Long id) {
        return roleRepo.findById(id).orElse(null);
    }

    @Override
    public void editRole(Role role) {
        roleRepo.save(role);
    }

}