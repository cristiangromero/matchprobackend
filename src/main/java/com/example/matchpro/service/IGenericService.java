package com.example.matchpro.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface IGenericService<Request, Response> {

    CrudRepository<?, Long> repository();

    Response create(Request request);
    List<Response> getAll();
    Optional<Response> get(long id);
    Optional<Response> update(long id, Request request);

    default boolean delete(long id) {
        try {
            repository().deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
