package com.example.matchpro.controller;

import com.example.matchpro.service.IGenericService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class GenericController<Request, Response> {

    protected abstract IGenericService<Request, Response> service();

    @GetMapping
    public ResponseEntity<List<Response>> getAll() {
        return ResponseEntity.ok(service().getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable("id") long id) {
        return ResponseEntity.of(service().get(id));
    }

    @PostMapping
    public ResponseEntity<Response> register(@RequestBody Request request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service().create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable("id") long id, @RequestBody Request request) {
        return ResponseEntity.of(service().update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") long id) {
        return service().delete(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
