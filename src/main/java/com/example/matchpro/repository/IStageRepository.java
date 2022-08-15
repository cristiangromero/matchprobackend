package com.example.matchpro.repository;

import com.example.matchpro.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The {@link Stage} repository.
 *
 * @author Alben Bustamante
 */
public interface IStageRepository extends JpaRepository<Stage, Long> {
}
