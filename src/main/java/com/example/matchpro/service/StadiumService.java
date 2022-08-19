package com.example.matchpro.service;

import com.example.matchpro.model.Stadium;
import com.example.matchpro.repository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadiumService implements IStadiumService {

    @Autowired
    public StadiumRepository stadiumRepo;

    @Override
    public List<Stadium> listStadium() {
        return stadiumRepo.findAll();
    }

    @Override
    public void newStadium(Stadium stadium) {
        stadiumRepo.save(stadium);
    }

    @Override
    public void deleteStadium(Stadium stadium) {
        stadiumRepo.delete(stadium);
    }

    @Override
    public Stadium findStadium(Long id) {
        return stadiumRepo.findById(id).orElse(null);
    }

    @Override
    public void editStadium(Stadium stadium) {
        stadiumRepo.save(stadium);
    }

}