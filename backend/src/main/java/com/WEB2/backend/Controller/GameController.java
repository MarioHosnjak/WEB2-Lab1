package com.WEB2.backend.Controller;

import com.WEB2.backend.Model.Game;
import com.WEB2.backend.Model.Tournament;
import com.WEB2.backend.Service.GameService;
import com.WEB2.backend.Service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/api/games")
    Iterable<Game> getTournament(@RequestParam("id") Integer tournamentId) {

        return gameService.getGamesByTournamentId(tournamentId);
    }

    @PostMapping("/api/editGameResult")
    String editGameResult(@RequestParam("newRes") Integer newRes, @RequestParam("gameId") Integer gameId) {

        System.out.println(newRes);
        System.out.println(gameId);

        // KAJ SAD?
        // DOHVATITI GAME prema id-ju
        // PROMJENITI rezultat na newRes
        // sejvati game
        // vratiti redirect na /tournament hash


        //System.out.println(gameModel.getId());
        //System.out.println(gameModel.getTeam1());
        //System.out.println(gameModel.getTeam2());


        return "model";
    }
}
