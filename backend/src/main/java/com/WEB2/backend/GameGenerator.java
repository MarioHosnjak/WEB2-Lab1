package com.WEB2.backend;

import com.WEB2.backend.Model.Game;
import com.WEB2.backend.Model.Tournament;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class GameGenerator {
    private String[] teamsArray;
    private Tournament tournament;
    private Integer teamsNumber;
    private Integer gameNumber;
    private Game[] games;

    public GameGenerator(String teams, Tournament tournament) {
        this.teamsArray = teams.split(",");
        this.tournament = tournament;
        this.teamsNumber = teamsArray.length;
        this.gameNumber = this.teamsNumber * (this.teamsNumber - 1) / 2;

        this.games = new Game[gameNumber];

        // [[0, 1], [2, 3], [0, 2], [1, 3], [0, 3], [1, 2]]
        List<List<Integer>> uniquePairs = new ArrayList<>();
        for (int i = 0; i < teamsArray.length; i++) {
            for (int j = i + 1; j < teamsArray.length; j++) {
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(j);

                if (!uniquePairs.contains(pair)) {
                    uniquePairs.add(pair);
                }
            }
        }
        // Shuffle the uniquePairs list
        Collections.shuffle(uniquePairs, new Random());

        for(int i = 0; i < uniquePairs.size(); i++) {
            Game newGame = new Game();
            newGame.setTeam1(teamsArray[uniquePairs.get(i).get(0)]);
            newGame.setTeam2(teamsArray[uniquePairs.get(i).get(1)]);
            newGame.setTournamentid(this.tournament);
            games[i] = newGame;
        }
    }

    public Game[] getGames() {
        return games;
    }
}
