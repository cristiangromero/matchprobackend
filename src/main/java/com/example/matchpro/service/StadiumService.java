package com.example.matchpro.service;

import com.example.matchpro.dto.stadium.StadiumRequest;
import com.example.matchpro.dto.stadium.StadiumResponse;
import com.example.matchpro.mapper.StadiumMapper;
import com.example.matchpro.model.Stadium;
import com.example.matchpro.repository.StadiumRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StadiumService implements IStadiumService{

    private final StadiumRepository repository;
    private final StadiumMapper mapper;

    @Override
    public CrudRepository<Stadium, Long> repository() {
        return repository;
    }

    @Override
    public StadiumResponse create(StadiumRequest stadiumRequest) {
        return mapper.toResponse(repository.save(mapper.toEntity(stadiumRequest)));
    }

    @Override
    public List<StadiumResponse> getAll() {
        return mapper.toResponses(repository.findAll());
    }

    @Override
    public Optional<StadiumResponse> get(long id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    @Override
    public Optional<StadiumResponse> update(long id, StadiumRequest stadiumRequest) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        final var entity = mapper.toEntity(stadiumRequest);
        entity.setStadiumId(id);

        return Optional.of(mapper.toResponse(repository.save(entity)));
    }

    @Override
    public Optional<StadiumResponse> getByName(String name) {
        return repository.findByName(name).map(mapper::toResponse);
    }

}