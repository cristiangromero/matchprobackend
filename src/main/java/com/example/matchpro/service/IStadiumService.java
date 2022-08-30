package com.example.matchpro.service;

import com.example.matchpro.model.Stadium;
import java.util.Optional;


public interface IStadiumService extends ICrudService<Stadium>{

    /**
     * Get a {@link Stadium} by the name.
     *
     * @param name the name to search.
     * @return an optional of the stadium.
     */
    Optional<Stadium> getByName(String name);

}
