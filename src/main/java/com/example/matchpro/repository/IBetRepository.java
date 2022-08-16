package com.example.matchpro.repository;

import com.example.matchpro.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The {@link Bet} repository.
 *
 * @author Alben Bustamante
 */
@Repository
public interface IBetRepository extends JpaRepository<Bet, Long> {
}
