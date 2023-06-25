package com.example.testtask.controller;

import com.example.testtask.entity.Team;
import com.example.testtask.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    TeamService teamService;

    @PostMapping
    ResponseEntity<Team> create(@RequestBody Team team){
        return new ResponseEntity<>(teamService.createTeam(team), HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    ResponseEntity<Team> getTeamByName(@PathVariable String name){
        return new ResponseEntity<>(teamService.findTeamBy(name), HttpStatus.OK);
    }

    @GetMapping()
    ResponseEntity<List<Team>> getAllTeam(){
        return new ResponseEntity<>(teamService.findAllTeam(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<Team> updateTeam(@PathVariable Long id,  @RequestBody Team team){
        return new ResponseEntity<>(teamService.updateTeam(id, team), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteTeam(@PathVariable Long id){
        teamService.deleteTeamBy(id);
    }
}
