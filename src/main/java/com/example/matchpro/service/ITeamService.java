package com.example.matchpro.service;

import com.example.matchpro.model.Team;
import java.util.Optional;

/**
 * The {@link Team} service template.
 *
 * @author Alben Bustamante
 */
public interface ITeamService extends ICrudService<Team> {

    /**
     * Get a {@link Team} by the name.
     *
     * @param name the name to search.
     * @return an optional of the team found.
     */
    Optional<Team> getByName(String name);

}
