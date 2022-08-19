package com.example.matchpro.controller;

import com.example.matchpro.model.Match;
import com.example.matchpro.service.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match")
@CrossOrigin
public class MatchController {
    @Autowired
    private IMatchService matchServ;

    //    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public void addMatch (@RequestBody Match match){
        matchServ.newMatch(match);
    }

    @GetMapping
    @ResponseBody
    public List<Match> listMatch(){
        return matchServ.listMatch();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Match findMatch(@PathVariable Long id){
        return matchServ.findMatch(id);
    }

    //    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public void deleteMatch (@PathVariable Long id){
        Match match= findMatch(id);
        matchServ.deleteMatch(match);
    }

    //    @PreAuthorize("isAuthenticated()")
    @PutMapping
    public void editMatch (@RequestBody Match match){
        matchServ.editMatch(match);
    }

    //    @PreAuthorize("isAuthenticated()")
    @PutMapping("/{id}")
    public void editMatch(@PathVariable Long id) {
        Match match= findMatch(id);
        matchServ.editMatch(match);
    }
}
