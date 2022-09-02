package com.example.matchpro.service;

import com.example.matchpro.dto.stadium.StadiumRequest;
import com.example.matchpro.dto.stadium.StadiumResponse;
import com.example.matchpro.model.Stadium;
import java.util.Optional;


public interface IStadiumService extends IGenericService<StadiumRequest, StadiumResponse> {

    /**
     * Get a {@link Stadium} by the name.
     *
     * @param name the name to search.
     * @return an optional of the stadium found.
     */
    Optional<StadiumResponse> getByName(String name);

}
