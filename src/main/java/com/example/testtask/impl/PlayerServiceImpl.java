package com.example.testtask.impl;

import com.example.testtask.entity.Player;
import com.example.testtask.exception.DuplicatePlayerException;
import com.example.testtask.exception.NoPlayerException;
import com.example.testtask.repository.PlayerRepository;
import com.example.testtask.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Player createPlayer(Player player) {
        Player playerResult = playerRepository.findPlayerByLastName(player.getLastName());
        if(playerResult == null){
            return playerRepository.save(player);
        }
        if (playerResult.getLastName().equals(player.getLastName())) {
            throw new DuplicatePlayerException("Already exists");
        }
        return playerRepository.save(player);
    }

    @Override
    public Player findPlayerBy(String lastName) {
        Optional<Player> playerResult = Optional.ofNullable(playerRepository.findPlayerByLastName(lastName));
        Player player;
        if (playerResult.isPresent()) {
            player = playerResult.get();
        } else {
            throw new NoPlayerException("No player");
        }
        return player;
    }

    @Override
    public List<Player> findAllPlayer() {
        List<Player> playerList = playerRepository.findAll();
        if(playerList.size() == 0){
            throw new NoPlayerException("No players");
        }else {
            return playerList;
        }
    }

    @Override
    public Player updatePlayer(Long id, Player player) {
        Optional<Player> playerResult = playerRepository.findById(id);
        Player playerIsPresent = null;
        if (playerResult.isPresent()) {
            playerIsPresent = playerResult.get();
            playerIsPresent.setFirstName(player.getFirstName());
            playerIsPresent.setLastName(player.getLastName());
            playerIsPresent.setCitizenship(player.getCitizenship());
            playerIsPresent.setBirthPlace(player.getBirthPlace());
            playerIsPresent.setBirthDate(player.getBirthDate());
            playerIsPresent.setTeam(player.getTeam());
        }
        return playerRepository.save(playerIsPresent);
    }

    @Override
    public void deletePlayerBy(Long id) {
        playerRepository.deleteById(id);
    }
}
