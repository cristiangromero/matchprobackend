package com.example.matchpro.repository;

import com.example.matchpro.model.Stage;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The {@link Stage} repository.
 *
 * @author Alben Bustamante
 */
@Repository
public interface IStageRepository extends JpaRepository<Stage, Long> {

    /**
     * Find a {@link Stage} by the name.
     *
     * @param name the name to search.
     * @return an optional of the stage found.
     */
    Optional<Stage> findByName(String name);

}
