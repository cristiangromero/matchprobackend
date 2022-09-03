package com.example.matchpro.controller;

import com.example.matchpro.dto.team.TeamRequest;
import com.example.matchpro.dto.team.TeamResponse;
import com.example.matchpro.model.Team;
import com.example.matchpro.service.IMatchService;
import com.example.matchpro.service.ITeamService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@RequestMapping("/update")
public class UpdateController{

    private final RestTemplate restTemplate;
    private final ITeamService iTeamService;
    private final IMatchService iMatchService;

    @Autowired
    public UpdateController(RestTemplate restTemplate, ITeamService iTeamService, IMatchService iMatchService){
        this.restTemplate = restTemplate;
        this.iTeamService = iTeamService;
        this.iMatchService = iMatchService;
    }

    @GetMapping("/teams")
    @ResponseBody
    public HttpStatus callTeams() {
        String url = "https://api.football-data.org/v4/competitions/WC/teams?season=2022";
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Auth-Token", "6a74b60a628949aaa04ead3cecd21a5a");
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        JSONObject ob = new JSONObject(response.getBody());
        JSONArray arr = new JSONArray(ob.get("teams").toString());

        ArrayList<TeamResponse> teams = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            // Obtener objeto a través del índice
            JSONObject team = arr.getJSONObject(i);
            // Acceder como accedíamos al jsonObject
            long teamId = team.getLong("id");
            String name = team.getString("name");
            String flag = team.getString("crest");
            // Luego de eso podemos crear la clase y obtener los beneficios
            // de la POO o usar los datos como nos plazca
            final var newTeam = new TeamRequest(teamId, name, flag);
            final var teamResponse = iTeamService.create(newTeam);
            // Agregar a la lista, solo para ilustrar
            teams.add(teamResponse);
        }
        return response.getStatusCode();
    }
  /*  @GetMapping("/matches")
    @ResponseBody
    public HttpStatus callMatches() {
        String url = "http://api.football-data.org/v4/competitions/2000/matches?season=2022";
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Auth-Token", "6a74b60a628949aaa04ead3cecd21a5a");
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        JSONObject ob = new JSONObject(response.getBody());
        JSONArray arr = new JSONArray(ob.get("teams").toString());

        ArrayList<Team> teams = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            // Obtener objeto a través del índice
            JSONObject team = arr.getJSONObject(i);
            // Acceder como accedíamos al jsonObject
            Long apiId = team.getLong("id");
            String name = team.getString("name");
            String flag = team.getString("crest");
            // Luego de eso podemos crear la clase y obtener los beneficios
            // de la POO o usar los datos como nos plazca
            Team newTeam = new Team(apiId, name, flag);
            iTeamService.create(newTeam);
            // Agregar a la lista, solo para ilustrar
            teams.add(newTeam);
        }
        return response.getStatusCode();
    }*/
}
