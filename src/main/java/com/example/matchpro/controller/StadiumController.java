package com.example.matchpro.controller;


import com.example.matchpro.model.Stadium;
import com.example.matchpro.service.IStadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stadium")
@CrossOrigin
public class StadiumController {
    @Autowired
    private IStadiumService stadiumServ;

    //    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public void addStadium (@RequestBody Stadium stadium){
        stadiumServ.newStadium(stadium);
    }

    @GetMapping
    @ResponseBody
    public List<Stadium> listStadium(){
        return stadiumServ.listStadium();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Stadium findStadium(@PathVariable Long id){
        return stadiumServ.findStadium(id);
    }

    //    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public void deleteStadium (@PathVariable Long id){
        Stadium stadium= findStadium(id);
        stadiumServ.deleteStadium(stadium);
    }

    //    @PreAuthorize("isAuthenticated()")
    @PutMapping
    public void editStadium (@RequestBody Stadium stadium){
        stadiumServ.editStadium(stadium);
    }

    //    @PreAuthorize("isAuthenticated()")
    @PutMapping("/{id}")
    public void editStadium(@PathVariable Long id) {
        Stadium stadium= findStadium(id);
        stadiumServ.editStadium(stadium);
    }
}
