package com.example.matchpro.controller;

import com.example.matchpro.model.Bet;
import com.example.matchpro.service.IBetService;
import com.example.matchpro.service.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@link Bet} REST controller.
 *
 * @author Alben Bustamante
 */
@RestController
@RequestMapping("/bets")
@RequiredArgsConstructor
public class BetController extends CrudController<Bet> {

    private final IBetService service;

    @Override
    protected ICrudService<Bet> service() {
        return service;
    }

}
