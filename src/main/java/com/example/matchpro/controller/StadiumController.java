package com.example.matchpro.controller;


import com.example.matchpro.dto.stadium.StadiumRequest;
import com.example.matchpro.dto.stadium.StadiumResponse;
import com.example.matchpro.service.IGenericService;
import com.example.matchpro.service.IStadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stadiums")
@CrossOrigin
@RequiredArgsConstructor
public class StadiumController extends GenericController<StadiumRequest, StadiumResponse>{

    private final IStadiumService service;

    @GetMapping("/name/{name}")
    public ResponseEntity<StadiumResponse> getByName(@PathVariable("name") String name) {
        return ResponseEntity.of(service.getByName(name));
    }

    @Override
    protected IGenericService<StadiumRequest, StadiumResponse> service() {
        return service;
    }

}