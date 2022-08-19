package com.example.matchpro.service;

import com.example.matchpro.model.Match;

import java.util.List;

public interface IMatchService {
    public List<Match> listMatch();
    public void newMatch(Match match);
    public void deleteMatch(Match match);
    public Match findMatch(Long id);
    public void editMatch(Match match);
}
