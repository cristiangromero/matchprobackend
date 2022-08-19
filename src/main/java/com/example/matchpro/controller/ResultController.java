package com.example.matchpro.controller;


import com.example.matchpro.model.Result;
import com.example.matchpro.service.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/result")
@CrossOrigin
public class ResultController {
    @Autowired
    private IResultService resultServ;

    //    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public void addResult (@RequestBody Result result){
        resultServ.newResult(result);
    }

    @GetMapping
    @ResponseBody
    public List<Result> listResult(){
        return resultServ.listResult();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Result findResult(@PathVariable Long id){
        return resultServ.findResult(id);
    }

    //    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public void deleteResult (@PathVariable Long id){
        Result result= findResult(id);
        resultServ.deleteResult(result);
    }

    //    @PreAuthorize("isAuthenticated()")
    @PutMapping
    public void editResult (@RequestBody Result result){
        resultServ.editResult(result);
    }

    //    @PreAuthorize("isAuthenticated()")
    @PutMapping("/{id}")
    public void editResult(@PathVariable Long id) {
        Result result= findResult(id);
        resultServ.editResult(result);
    }
}
