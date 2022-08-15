package com.example.matchpro.service;

import com.example.matchpro.model.Result;

import java.util.List;

public interface IResultService {
    public List<Result> listResult();
    public void newResult(Result result);
    public void deleteResult(Result result);
    public Result findResult(Long id);
    public void editResult(Result result);
}
