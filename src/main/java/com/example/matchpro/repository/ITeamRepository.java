package com.example.matchpro.repository;

import com.example.matchpro.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The {@link Team} repository.
 *
 * @author Alben Bustamante
 */
@Repository
public interface ITeamRepository extends JpaRepository<Team, Long> {
}
