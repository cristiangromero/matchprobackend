package com.example.matchpro.service;

import com.example.matchpro.model.Match;
import com.example.matchpro.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService implements IMatchService{

    @Autowired
    public MatchRepository matchRepo;

    @Override
    public List<Match> listMatch() {
        return matchRepo.findAll();
    }

    @Override
    public void newMatch(Match match) {
        matchRepo.save(match);
    }

    @Override
    public void deleteMatch(Match match) {
        matchRepo.delete(match);
    }

    @Override
    public Match findMatch(Long id) {
        return matchRepo.findById(id).orElse(null);
    }

    @Override
    public void editMatch(Match match) {
        matchRepo.save(match);
    }

}
