package com.example.matchpro.service;

import com.example.matchpro.model.Result;
import com.example.matchpro.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService implements IResultService {

    @Autowired
    public ResultRepository resultRepo;

    @Override
    public List<Result> listResult() {
        return resultRepo.findAll();
    }

    @Override
    public void newResult(Result result) {
        resultRepo.save(result);
    }

    @Override
    public void deleteResult(Result result) {
        resultRepo.delete(result);
    }

    @Override
    public Result findResult(Long id) {
        return resultRepo.findById(id).orElse(null);
    }

    @Override
    public void editResult(Result result) {
        resultRepo.save(result);
    }

}