package com.example.matchpro.controller;

import com.example.matchpro.model.User;
import com.example.matchpro.service.ICrudService;
import com.example.matchpro.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@link User} REST controller.
 *
 * @author Alben Bustamante
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController extends CrudController<User> {

    private final IUserService service;

    @Override
    protected ICrudService<User> service() {
        return service;
    }

    /**
     * Get an {@link User} by the email.
     *
     * @param email the email to search.
     * @return a {@link ResponseEntity} with the user found (CODE 200) or empty (CODE 404).
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email) {
        return ResponseEntity.of(service.getByEmail(email));
    }

}
