package com.example.matchpro.controller;

import com.example.matchpro.model.Team;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TestController {
    private final RestTemplate restTemplate;

    @Autowired
    public TestController(RestTemplate restTemplate){

        this.restTemplate = restTemplate;
    }

    /*
    @GetMapping("/test")
    public Test getApi(){
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        Test test = restTemplate.getForObject(url,Test.class);
        return test;
    }
    @GetMapping("/test/list")
    public List<Test> getListApi(){
        String url = "https://jsonplaceholder.typicode.com/todos";
        Test[] test = restTemplate.getForObject(url,Test[].class);
        return Arrays.asList(test);
    }*/

   @GetMapping("/tlist")
   @ResponseBody
   public String callExternalApi() {
       String url = "https://api.football-data.org/v4/competitions/WC/teams?season=2022";
       HttpHeaders headers = new HttpHeaders();
       headers.add("X-Auth-Token", "6a74b60a628949aaa04ead3cecd21a5a");
       HttpEntity<Object> entity=new HttpEntity<Object>(headers);

       ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
       JSONObject ob = new JSONObject(response.getBody());
       JSONArray arr = new JSONArray(ob.get("teams").toString());
       JSONObject team = (JSONObject) arr.get(0);
       return team.toString();
   }

    @GetMapping("/tlis")
    @ResponseBody
    public String callE() {
        String url = "https://api.football-data.org/v4/competitions/WC/teams?season=2022";
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Auth-Token", "6a74b60a628949aaa04ead3cecd21a5a");
        HttpEntity<Object> entity=new HttpEntity<Object>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        JSONObject ob = new JSONObject(response.getBody());
        JSONArray arr = new JSONArray(ob.get("teams").toString());

        ArrayList<Team> teams = new ArrayList<>();
        for (int indice = 0; indice < arr.length(); indice++) {
            // Obtener objeto a través del índice
            JSONObject team = arr.getJSONObject(indice);
            // Acceder como accedíamos al jsonObject
            Long teamId = team.getLong("id");
            String name = team.getString("name");
            String flag = team.getString("crest");
            // Luego de eso podemos crear la clase y obtener los beneficios
            // de la POO o usar los datos como nos plazca
            Team newTeam = new Team(teamId,name,flag);
            // Agregar a la lista, solo para ilustrar
            teams.add(newTeam);
        }
        return teams.toString();
    }

}
