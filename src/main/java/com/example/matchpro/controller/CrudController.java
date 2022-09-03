package com.example.matchpro.controller;

import com.example.matchpro.service.ICrudService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The generic and abstract controller with the crud methods.
 *
 * @param <T> the entity to use.
 * @author Alben Bustamante
 */
public abstract class CrudController<T> {

    /**
     * Set the service to be used.
     * @return the service.
     */
    protected abstract ICrudService<T> service();

    /**
     * Create and persist a new element.
     *
     * @param t the element to be registered.
     * @return a {@link ResponseEntity} with the element registered.
     */
    @ApiResponse(code = 201, message = "Elemento registrado exitosamente")
    @ApiOperation(value = "Registra un nuevo elemento")
    @PostMapping
    public ResponseEntity<T> register(@RequestBody T t) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service().create(t));
    }

    /**
     * @return a {@link ResponseEntity} with all the elements registered.
     */
    @ApiResponse(code = 200, message = "OK")
    @ApiOperation(value = "Obtén una lista con todos los elementos registrados")
    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        return ResponseEntity.ok(service().getAll());
    }

    /**
     * Get an existing element by the id.
     *
     * @param id the id to search.
     * @return a {@link ResponseEntity} with the element found (CODE 200) or empty (CODE 404).
     */
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Elemento no encontrado")
    })
    @ApiOperation(value = "Obtén un elemento existente por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<T> get(@PathVariable("id") long id) {
        return ResponseEntity.of(service().get(id));
    }

    /**
     * Update an existing element by the id.
     *
     * @param id the id to search and be updated.
     * @param t the body to use on the existing element.
     * @return a {@link ResponseEntity} with the element updated (CODE 200) or empty if not exists (CODE 404).
     */
    @ApiResponses({
            @ApiResponse(code = 200, message = "Elemento actualizado exitosamente"),
            @ApiResponse(code = 404, message = "Elemento no encontrado")
    })
    @ApiOperation(value = "Actualiza un elemento existente por su ID")
    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable("id") long id, @RequestBody T t) {
        return ResponseEntity.of(service().update(id, t));
    }

    /**
     * Delete an existing element by the id.
     *
     * @param id the id to search and be removed.
     * @return a {@link ResponseEntity} with code 200 if it was removed successfully or 404 if not.
     */
    @ApiResponses({
            @ApiResponse(code = 200, message = "Elemento eliminado exitosamente"),
            @ApiResponse(code = 404, message = "Elemento no encontrado")
    })
    @ApiOperation(value = "Elimina un elemento existente por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<T> delete(@PathVariable("id") long id) {
        return service().delete(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
