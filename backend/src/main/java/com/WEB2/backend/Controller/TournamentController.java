package com.WEB2.backend.Controller;

import com.WEB2.backend.Model.Tournament;
import com.WEB2.backend.Service.TournamentService;
import com.nimbusds.oauth2.sdk.http.HTTPResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

import java.util.List;


@RestController
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping("/tournament")
    ModelAndView getTournament(@RequestParam("hash") String hash) {
        ModelAndView model = new ModelAndView("tournament");
        Tournament tournament = tournamentService.getTournamentByHash(hash);
        model.addObject("name", tournament.getTournamentname());
        model.addObject("sport", tournament.getSportname().getId());
        model.addObject("tournamentid", tournament.getId().toString());
        model.addObject("userid", tournament.getUserid().toString());
        model.addObject("hash", tournament.getTournamenthash());
        //return tournamentService.getTournamentByHash(hash);
        return model;
    }

    @GetMapping("/api/gettournaments")
    List<Object[]> getTournamentsByUsername(Authentication authentication) {
        DefaultOidcUser userDetails = (DefaultOidcUser) authentication.getPrincipal();
        String username = userDetails.getFullName();
        return tournamentService.getTournamentByUsername(username);
    }

    @GetMapping("/createTournament")
    ModelAndView createTournament() {
        ModelAndView model = new ModelAndView("createTournament");
        return model;
    }
}
