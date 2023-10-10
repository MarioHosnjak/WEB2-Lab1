package com.WEB2.backend.Model;

import com.WEB2.backend.Model.Tournament;
import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "game")
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gameid", nullable = false)
    private Integer id;

    @Column(name = "result", length = 1)
    private String result;

    @Column(name = "gametime")
    private LocalDate gametime;

    @Column(name = "team1", nullable = false, length = 25)
    private String team1;

    @Column(name = "team2", nullable = false, length = 25)
    private String team2;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tournamentid", nullable = false)
    private Tournament tournamentid;

    public Tournament getTournamentid() {
        return tournamentid;
    }

    public void setTournamentid(Tournament tournamentid) {
        this.tournamentid = tournamentid;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public LocalDate getGametime() {
        return gametime;
    }

    public void setGametime(LocalDate gametime) {
        this.gametime = gametime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}