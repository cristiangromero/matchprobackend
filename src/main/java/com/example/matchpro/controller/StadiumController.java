package com.example.matchpro.controller;


import com.example.matchpro.model.Stadium;
import com.example.matchpro.service.ICrudService;
import com.example.matchpro.service.IStadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stadium")
@CrossOrigin
@RequiredArgsConstructor
public class StadiumController extends CrudController<Stadium>{

    private final IStadiumService service;

    @Override
    protected ICrudService<Stadium> service() {
        return service;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Stadium> getByName(@PathVariable("name") String name) {
        return ResponseEntity.of(service.getByName(name));
    }

}