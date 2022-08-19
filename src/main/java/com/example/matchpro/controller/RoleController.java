package com.example.matchpro.controller;


import com.example.matchpro.model.Role;
import com.example.matchpro.service.ICrudService;
import com.example.matchpro.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@CrossOrigin
@RequiredArgsConstructor
public class RoleController extends CrudController<Role>{

    private final IRoleService service;

    @Override
    protected ICrudService<Role> service() {
        return service;
    }
}