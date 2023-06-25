package com.example.testtask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long team_id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "budget")
    private int budget;

    @Column(name = "stadium")
    private String stadium;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> players;

    public Team() {
    }

    public Team(Long team_id, String name, String country, String city, int budget, String stadium) {
        this.team_id = team_id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.budget = budget;
        this.stadium = stadium;
    }

    public Long getTeam_id() {
        return team_id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public int getBudget() {
        return budget;
    }

    public String getStadium() {
        return stadium;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "team_id=" + team_id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", budget=" + budget +
                ", stadium='" + stadium + '\'' +
                '}';
    }
}
