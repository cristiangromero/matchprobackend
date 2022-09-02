package com.example.matchpro.service.impl;

import com.example.matchpro.dto.match.MatchRequest;
import com.example.matchpro.dto.match.MatchResponse;
import com.example.matchpro.mapper.MatchMapper;
import com.example.matchpro.model.Match;
import com.example.matchpro.repository.MatchRepository;
import com.example.matchpro.service.IMatchService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchService implements IMatchService {

    private final MatchRepository repository;
    private final MatchMapper mapper;

    @Override
    public CrudRepository<Match, Long> repository() {
        return repository;
    }

    @Override
    public MatchResponse create(MatchRequest matchRequest) {
        return mapper.toResponse(repository.save(mapper.toEntity(matchRequest)));
    }

    @Override
    public List<MatchResponse> getAll() {
        return mapper.toResponses(repository.findAll());
    }

    @Override
    public Optional<MatchResponse> get(long id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    @Override
    public Optional<MatchResponse> update(long id, MatchRequest matchRequest) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        final var entity = mapper.toEntity(matchRequest);
        entity.setMatchId(id);

        return Optional.of(mapper.toResponse(repository.save(entity)));
    }

}
