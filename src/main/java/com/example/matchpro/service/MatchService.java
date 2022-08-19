package com.example.matchpro.service;

import com.example.matchpro.model.Match;
import com.example.matchpro.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatchService extends CrudService<Match> implements IMatchService{

    private final MatchRepository repository;

    @Override
    protected CrudRepository<Match, Long> repository() {
        return repository;
    }

    @Override
    public Optional<Match> update(long id, Match match) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        match.setMatchId(id);

        return Optional.of(repository.save(match));
    }

}
