package com.example.matchpro.service;

import java.util.List;
import java.util.Optional;

/**
 * @author Alben Bustamante
 */
public interface ICrudService<T> {

    /**
     * Create and persist a new element.
     *
     * @param t the element to be registered.
     * @return the element registered.
     */
    T create(T t);

    /**
     * @return all the elements registered.
     */
    List<T> getAll();

    /**
     * @param id the id to search.
     * @return an optional of the element found.
     */
    Optional<T> get(long id);

    /**
     * Update an existing element by the id.
     *
     * @param id the id to search and update.
     * @param t the body for update the existing element.
     * @return an optional of the element updated.
     */
    Optional<T> update(long id, T t);

    /**
     * Delete and existing element by the id.
     *
     * @param id the id to search.
     * @return {@code true} if the element exists and is removed.
     */
    boolean delete(long id);
}
