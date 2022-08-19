package com.example.matchpro.service;

import com.example.matchpro.model.Result;
import com.example.matchpro.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResultService extends CrudService<Result> implements IResultService{

    private final ResultRepository repository;

    @Override
    protected CrudRepository<Result, Long> repository() {
        return repository;
    }

    @Override
    public Optional<Result> update(long id, Result result) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        result.setResultId(id);

        return Optional.of(repository.save(result));
    }

}