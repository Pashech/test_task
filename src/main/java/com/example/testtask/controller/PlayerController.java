package com.example.testtask.controller;

import com.example.testtask.entity.Player;
import com.example.testtask.service.PlayerService;
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
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping
    ResponseEntity<Player> create(@RequestBody Player player){
        return new ResponseEntity<>(playerService.createPlayer(player), HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    ResponseEntity<Player> getPlayerByName(@PathVariable String name){
        return new ResponseEntity<>(playerService.findPlayerBy(name), HttpStatus.OK);
    }

    @GetMapping()
    ResponseEntity<List<Player>> getAllPlayer(){
        return new ResponseEntity<>(playerService.findAllPlayer(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<Player> updatePlayer(@PathVariable Long id,  @RequestBody Player player){
        return new ResponseEntity<>(playerService.updatePlayer(id, player), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deletePlayer(@PathVariable Long id){
        playerService.deletePlayerBy(id);
    }
}
