package com.example.matchpro.service.impl;

import com.example.matchpro.dto.team.TeamRequest;
import com.example.matchpro.dto.team.TeamResponse;
import com.example.matchpro.mapper.TeamMapper;
import com.example.matchpro.model.Team;
import com.example.matchpro.repository.ITeamRepository;
import com.example.matchpro.service.ITeamService;
import java.util.List;
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
public class TeamService implements ITeamService {

    private final ITeamRepository repository;
    private final TeamMapper mapper;

    @Override
    public CrudRepository<Team, Long> repository() {
        return repository;
    }

    @Override
    public TeamResponse create(TeamRequest teamRequest) {
        return mapper.toResponse(repository.save(mapper.toEntity(teamRequest)));
    }

    @Override
    public List<TeamResponse> getAll() {
        return mapper.toResponses(repository.findAll());
    }

    @Override
    public Optional<TeamResponse> get(long id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    @Override
    public Optional<TeamResponse> update(long id, TeamRequest teamRequest) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        final var entity = mapper.toEntity(teamRequest);
        entity.setTeamId(id);

        return Optional.of(mapper.toResponse(repository.save(entity)));
    }

    @Override
    public Optional<TeamResponse> getByName(String name) {
        return repository.findByName(name).map(mapper::toResponse);
    }

}
