package com.example.matchpro.service;

import com.example.matchpro.model.Team;
import com.example.matchpro.repository.ITeamRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * The {@link ITeamService} implementation.
 *
 * @author Alben Bustamante
 */
@Service
@RequiredArgsConstructor
public class TeamService extends CrudService<Team> implements ITeamService {

    private final ITeamRepository repository;

    @Override
    protected CrudRepository<Team, Long> repository() {
        return repository;
    }

    @Override
    public Optional<Team> update(long id, Team team) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        team.setTeamId(id);

        return Optional.of(repository.save(team));
    }

    @Override
    public Optional<Team> getByName(String name) {
        return repository.findByName(name);
    }
}
