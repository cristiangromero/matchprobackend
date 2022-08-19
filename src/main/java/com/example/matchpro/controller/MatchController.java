package com.example.matchpro.controller;

import com.example.matchpro.model.Match;
import com.example.matchpro.service.ICrudService;
import com.example.matchpro.service.IMatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/match")
@CrossOrigin
@RequiredArgsConstructor
public class MatchController extends CrudController<Match>{

    private final IMatchService service;

    @Override
    protected ICrudService<Match> service() {
        return service;
    }
}
