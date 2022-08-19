package com.example.matchpro.service;

import com.example.matchpro.model.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> listRole();
    public void newRole(Role role);
    public void deleteRole(Role role);
    public Role findRole(Long id);
    public void editRole(Role role);
}
