package com.example.matchpro.service;

import com.example.matchpro.model.Stadium;
import com.example.matchpro.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StadiumService extends CrudService<Stadium> implements IStadiumService{

    private final StadiumRepository repository;

    @Override
    protected CrudRepository<Stadium, Long> repository() {
        return repository;
    }

    @Override
    public Optional<Stadium> update(long id, Stadium stadium) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        stadium.setStadiumId(id);

        return Optional.of(repository.save(stadium));
    }

}