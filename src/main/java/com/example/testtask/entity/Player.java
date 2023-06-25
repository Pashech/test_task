package com.example.testtask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long player_id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "citizenship")
    private String citizenship;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "birth_Date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;

    public Player() {
    }

    public Player(Long player_id, String firstName, String lastName, String citizenship, String birthPlace, LocalDate birthDate) {
        this.player_id = player_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.citizenship = citizenship;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
    }

    public Long getPlayer_id() {
        return player_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Team getTeam() {
        return team;
    }

    public void setPlayer_id(Long player_id) {
        this.player_id = player_id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "player_id=" + player_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", citizenship='" + citizenship + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
