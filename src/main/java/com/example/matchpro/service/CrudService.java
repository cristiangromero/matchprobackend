package com.example.matchpro.service;

import java.util.List;
import java.util.Optional;

/**
 * @author Alben Bustamante
 */
public interface CrudService<T> {
    T create(T t);
    List<T> getAll();
    Optional<T> get(long id);
    Optional<T> update(long id, T t);
    boolean delete(long id);
}
