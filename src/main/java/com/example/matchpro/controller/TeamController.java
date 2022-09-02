package com.example.matchpro.controller;

import com.example.matchpro.dto.team.TeamRequest;
import com.example.matchpro.dto.team.TeamResponse;
import com.example.matchpro.model.Team;
import com.example.matchpro.service.IGenericService;
import com.example.matchpro.service.ITeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@link Team} REST controller.
 *
 * @author Alben Bustamante
 */
@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController extends GenericController<TeamRequest, TeamResponse> {

    private final ITeamService service;

    @GetMapping("/name/{name}")
    public ResponseEntity<TeamResponse> getByName(@PathVariable("name") String name) {
        return ResponseEntity.of(service.getByName(name));
    }

    @Override
    protected IGenericService<TeamRequest, TeamResponse> service() {
        return service;
    }

}
