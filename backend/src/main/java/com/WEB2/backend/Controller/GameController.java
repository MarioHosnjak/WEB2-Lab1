package com.WEB2.backend.Controller;

import com.WEB2.backend.Model.Game;
import com.WEB2.backend.Model.Tournament;
import com.WEB2.backend.Service.GameService;
import com.WEB2.backend.Service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/api/games")
    Iterable<Game> getTournament(@RequestParam("id") Integer tournamentId) {

        return gameService.getGamesByTournamentId(tournamentId);
    }
}
