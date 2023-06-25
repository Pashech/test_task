package com.example.testtask.repository;

import com.example.testtask.entity.Player;
import com.example.testtask.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findPlayerByLastName(String lastName);
}
