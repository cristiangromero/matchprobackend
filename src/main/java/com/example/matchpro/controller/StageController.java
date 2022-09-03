package com.example.matchpro.controller;

import com.example.matchpro.model.Stage;
import com.example.matchpro.service.ICrudService;
import com.example.matchpro.service.IStageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@link Stage} REST controller.
 *
 * @author Alben Bustamante
 */
@RestController
@RequestMapping("/stages")
@RequiredArgsConstructor
public class StageController extends CrudController<Stage> {

    private final IStageService service;

    @Override
    protected ICrudService<Stage> service() {
        return service;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Stage> getByName(@PathVariable("name") String name) {
        return ResponseEntity.of(service.getByName(name));
    }

}
