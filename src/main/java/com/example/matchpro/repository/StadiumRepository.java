package com.example.matchpro.repository;

import com.example.matchpro.model.Stadium;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {

    /**
     * Find a {@link Stadium} by the name.
     *
     * @param name the name to search.
     * @return an optional of the stadium found.
     */
    Optional<Stadium> findByName(String name);

}
