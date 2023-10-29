package com.WEB2.backend.Service;

import com.WEB2.backend.Model.Game;
import com.WEB2.backend.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Iterable<Game> getGamesByTournamentId(Integer id){
        return gameRepository.findByTournamentidId(id);
    }

    public void addGames(Game[] games) {
        for(int i = 0; i < games.length; i++){
            System.out.println(i);
            System.out.println(games[i].getTeam1());
            System.out.println(games[i].getTeam2());
            System.out.println(games[i].getId());
            gameRepository.save(games[i]);
        }
        return;
    }
}
