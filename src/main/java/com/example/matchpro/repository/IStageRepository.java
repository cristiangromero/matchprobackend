package com.example.matchpro.repository;

import com.example.matchpro.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The {@link Stage} repository.
 *
 * @author Alben Bustamante
 */
@Repository
public interface IStageRepository extends JpaRepository<Stage, Long> {
}
