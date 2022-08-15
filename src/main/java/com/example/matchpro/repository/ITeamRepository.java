package com.example.matchpro.repository;

import com.example.matchpro.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The {@link Team} repository.
 *
 * @author Alben Bustamante
 */
public interface ITeamRepository extends JpaRepository<Team, Long> {
}
