package com.example.matchpro.service;

import com.example.matchpro.model.Stage;
import java.util.Optional;

/**
 * The {@link Stage} service template.
 *
 * @author Alben Bustamante
 */
public interface IStageService extends ICrudService<Stage> {

    /**
     * Get a {@link Stage} by the name.
     *
     * @param name the name.
     * @return an optional of the stage found.
     */
    Optional<Stage> getByName(String name);

}
