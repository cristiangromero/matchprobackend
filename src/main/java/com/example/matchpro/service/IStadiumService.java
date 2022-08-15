package com.example.matchpro.service;

import com.example.matchpro.model.Stadium;

import java.util.List;

public interface IStadiumService {
    public List<Stadium> listStadium();
    public void newStadium(Stadium stadium);
    public void deleteStadium(Stadium stadium);
    public Stadium findStadium(Long id);
    public void editStadium(Stadium stadium);
}

