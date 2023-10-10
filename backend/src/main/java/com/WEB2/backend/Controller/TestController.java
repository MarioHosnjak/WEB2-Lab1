package com.WEB2.backend.Controller;

import com.WEB2.backend.Model.Game;
import com.WEB2.backend.Model.Usertable;
import com.WEB2.backend.Repository.GameRepository;
import com.WEB2.backend.Service.UsertableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UsertableService usertableService;

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("api/accounts")
    Iterable<Usertable> getAccountInfo() {
        return usertableService.listAll();
    }

    @GetMapping("api/games")
    Iterable<Game> getGames() {
        return gameRepository.findAll();
    }
}
