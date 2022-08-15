package com.example.matchpro.repository;

import com.example.matchpro.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The {@link Bet} repository.
 *
 * @author Alben Bustamante
 */
public interface IBetRepository extends JpaRepository<Bet, Long> {
}
