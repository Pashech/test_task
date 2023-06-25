package com.example.testtask.service;

import com.example.testtask.entity.Player;
import com.example.testtask.entity.Team;

import java.util.List;

public interface PlayerService {

    Player createPlayer(Player player);
    Player findPlayerBy(String name);
    List<Player> findAllPlayer();
    Player updatePlayer(Long id, Player player);
    void deletePlayerBy(Long id);
}
