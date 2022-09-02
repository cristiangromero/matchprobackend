package com.example.matchpro.service;

import com.example.matchpro.dto.team.TeamRequest;
import com.example.matchpro.dto.team.TeamResponse;
import com.example.matchpro.model.Team;
import java.util.Optional;

/**
 * The {@link Team} service template.
 *
 * @author Alben Bustamante
 */
public interface ITeamService extends IGenericService<TeamRequest, TeamResponse> {

    /**
     * Get a {@link Team} by the name.
     *
     * @param name the name to search.
     * @return an optional of the team found.
     */
    Optional<TeamResponse> getByName(String name);

}
