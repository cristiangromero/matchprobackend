package com.example.matchpro.repository;

import com.example.matchpro.model.Team;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The {@link Team} repository.
 *
 * @author Alben Bustamante
 */
@Repository
public interface ITeamRepository extends JpaRepository<Team, Long> {

    /**
     * Find a {@link Team} by the name.
     *
     * @param name the name to search.
     * @return the team found.
     */
    Optional<Team> findByName(String name);

}
