package com.example.matchpro.controller;

import com.example.matchpro.dto.match.MatchRequest;
import com.example.matchpro.dto.match.MatchResponse;
import com.example.matchpro.service.IGenericService;
import com.example.matchpro.service.IMatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/matches")
@CrossOrigin
@RequiredArgsConstructor
public class MatchController extends GenericController<MatchRequest, MatchResponse>{

    private final IMatchService service;

    @Override
    protected IGenericService<MatchRequest, MatchResponse> service() {
        return service;
    }

}
