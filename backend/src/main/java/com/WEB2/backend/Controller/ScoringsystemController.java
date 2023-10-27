package com.WEB2.backend.Controller;

import com.WEB2.backend.Model.Scoringsystem;
import com.WEB2.backend.Service.ScoringsystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Optional;

@RestController
public class ScoringsystemController {

    @Autowired
    private ScoringsystemService scorinsystemService;

    //  http://localhost:8080/api/allscoringsystems
    @GetMapping("/api/allscoringsystems")
    Iterable<Scoringsystem> getScoringsystemBySportname() {
        return scorinsystemService.getAllScoringsystems();
    }

    //  http://localhost:8080/api/scoringsystem?sport=Nogomet
    @GetMapping("/api/scoringsystem")
    Optional<Scoringsystem> getScoringsystemBySportname(@RequestParam("sport") String sportname) {
        //Optional<Scoringsystem> ss = scorinsystemService.findBySportname(sportname);
        //Array returnArray = [ss.getWinpts(), ss.getDrawpts(), ss.getLosepts()];
        return scorinsystemService.findBySportname(sportname);
    }

}
