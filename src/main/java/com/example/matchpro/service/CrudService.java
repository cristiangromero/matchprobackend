package com.example.matchpro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * The {@link ICrudService} implementation.
 *
 * @author Alben Bustamante
 */
public abstract class CrudService<T> implements ICrudService<T> {

    protected abstract CrudRepository<T, Long> repository();

    @Override
    public T create(T t) {
        return repository().save(t);
    }

    @Override
    public List<T> getAll() {
        return (ArrayList<T>) repository().findAll();
    }

    @Override
    public Optional<T> get(long id) {
        return repository().findById(id);
    }

    @Override
    public boolean delete(long id) {
        try {
            repository().deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
