package com.example.matchpro.controller;

import com.example.matchpro.model.Team;
import com.example.matchpro.service.ICrudService;
import com.example.matchpro.service.ITeamService;
import lombok.RequiredArgsConstructor;
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
public class TeamController extends CrudController<Team> {

    private final ITeamService service;

    @Override
    protected ICrudService<Team> service() {
        return service;
    }

}
