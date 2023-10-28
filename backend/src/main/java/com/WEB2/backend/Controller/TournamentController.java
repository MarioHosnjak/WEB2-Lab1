package com.WEB2.backend.Controller;

import com.WEB2.backend.Model.Scoringsystem;
import com.WEB2.backend.Model.Tournament;
import com.WEB2.backend.Model.Usertable;
import com.WEB2.backend.Service.ScoringsystemService;
import com.WEB2.backend.Service.TournamentService;
import com.WEB2.backend.Service.UsertableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

import java.util.List;
import java.util.Optional;

import com.WEB2.backend.HashingUtil;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private UsertableService usertableService;

    @Autowired
    private ScoringsystemService scoringsystemService;

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

    @PostMapping("/api/createTournament")
    RedirectView createTournament(Authentication authentication, @RequestParam("name") String name, @RequestParam("sport") String sport, @RequestParam("teams") String teams) {
        // Authenticate user
        DefaultOidcUser userDetails = (DefaultOidcUser) authentication.getPrincipal();
        String username = userDetails.getFullName();
        Usertable user = usertableService.findUserByUsername(username);
        if(user == null){
            Usertable newUser = usertableService.createUser(username);
            user = newUser;
        }
        // Get scoring system
        Optional<Scoringsystem> ss = scoringsystemService.findBySportname(sport);
        if (!ss.isPresent()){
            //return "Invalid sport!";
            System.out.println("Invalid sport!");
        }
        Scoringsystem ss2 = ss.get();

        // Create new tournament
        Tournament newTournament = new Tournament();
        newTournament.setTournamentname(name);
        newTournament.setSportname(ss2);
        newTournament.setUserid(user);
        Tournament createdTournament = tournamentService.addNewTournament(newTournament);

        // Add hash to the new tournament
        String hash = HashingUtil.hashTo10Chars(createdTournament.getId().toString());
        createdTournament.setTournamenthash(hash);
        Tournament createdTournament2 = tournamentService.addNewTournament(createdTournament);

        return new RedirectView("/mytournaments");
    }
}
