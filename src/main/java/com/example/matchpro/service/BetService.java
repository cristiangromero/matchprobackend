package com.example.matchpro.service;

import com.example.matchpro.model.Bet;
import com.example.matchpro.repository.IBetRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * The {@link IBetService} implementation.
 *
 * @author Alben Bustamante
 */
@Service
@RequiredArgsConstructor
public class BetService extends CrudService<Bet> implements IBetService {

    private final IBetRepository repository;

    @Override
    protected CrudRepository<Bet, Long> repository() {
        return repository;
    }

    @Override
    public Optional<Bet> update(long id, Bet bet) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        bet.setBetId(id);

        return Optional.of(repository.save(bet));
    }
}
