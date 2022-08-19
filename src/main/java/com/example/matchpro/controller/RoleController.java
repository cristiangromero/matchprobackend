package com.example.matchpro.controller;


import com.example.matchpro.model.Role;
import com.example.matchpro.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
@CrossOrigin
public class RoleController {
    @Autowired
    private IRoleService roleServ;

    //    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public void addRole (@RequestBody Role role){
        roleServ.newRole(role);
    }

    @GetMapping
    @ResponseBody
    public List<Role> listRole(){
        return roleServ.listRole();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Role findRole(@PathVariable Long id){
        return roleServ.findRole(id);
    }

    //    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public void deleteRole (@PathVariable Long id){
        Role role= findRole(id);
        roleServ.deleteRole(role);
    }

    //    @PreAuthorize("isAuthenticated()")
    @PutMapping
    public void editRole (@RequestBody Role role){
        roleServ.editRole(role);
    }

    //    @PreAuthorize("isAuthenticated()")
    @PutMapping("/{id}")
    public void editRole(@PathVariable Long id) {
        Role role= findRole(id);
        roleServ.editRole(role);
    }
}
