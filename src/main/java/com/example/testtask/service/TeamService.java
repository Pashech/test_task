package com.example.testtask.service;

import com.example.testtask.entity.Team;

import java.util.List;

public interface TeamService {

    Team createTeam(Team team);
    Team findTeamBy(String name);
    List<Team> findAllTeam();
    Team updateTeam(Long id, Team team);
    void deleteTeamBy(Long id);
}
