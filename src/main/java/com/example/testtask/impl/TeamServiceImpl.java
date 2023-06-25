package com.example.testtask.impl;

import com.example.testtask.entity.Team;
import com.example.testtask.exception.DuplicateTeamException;
import com.example.testtask.exception.NoTeamException;
import com.example.testtask.repository.TeamRepository;
import com.example.testtask.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Override
    public Team createTeam(Team team) {
        Team teamResult = teamRepository.findTeamByName(team.getName());
        if(teamResult == null){
            return teamRepository.save(team);
        }
        if (teamResult.getName().equals(team.getName())) {
            throw new DuplicateTeamException("Already exists");
        }
        return teamRepository.save(team);
    }

    @Override
    public Team findTeamBy(String name) {
        Optional<Team> teamResult = Optional.ofNullable(teamRepository.findTeamByName(name));
        Team team;
        if (teamResult.isPresent()) {
            team = teamResult.get();
        } else {
            throw new NoTeamException("No team");
        }
        return team;
    }

    @Override
    public List<Team> findAllTeam() {
        List<Team> teamList = teamRepository.findAll();
        if(teamList.size() == 0){
            throw new NoTeamException("No teams");
        }else {
            return teamList;
        }
    }

    @Override
    public Team updateTeam(Long id, Team team) {
        Optional<Team> teamResult = teamRepository.findById(id);
        Team teamIsPresent = null;
        if (teamIsPresent == null) {
            throw new NoTeamException("No team");
        }
        if (teamResult.isPresent()) {
            teamIsPresent = teamResult.get();
            teamIsPresent.setName(team.getName());
            teamIsPresent.setCountry(team.getCountry());
            teamIsPresent.setCity(team.getCity());
            teamIsPresent.setBudget(team.getBudget());
            teamIsPresent.setStadium(team.getStadium());
        }
        return teamRepository.save(teamIsPresent);
    }

    @Override
    public void deleteTeamBy(Long id) {
        teamRepository.deleteById(id);
    }
}
