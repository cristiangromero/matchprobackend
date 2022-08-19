package com.example.matchpro.controller;


import com.example.matchpro.model.Result;
import com.example.matchpro.service.ICrudService;
import com.example.matchpro.service.IResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/result")
@CrossOrigin
@RequiredArgsConstructor
public class ResultController extends CrudController<Result>{

    private final IResultService service;

    @Override
    protected ICrudService<Result> service() {
        return service;
    }
}