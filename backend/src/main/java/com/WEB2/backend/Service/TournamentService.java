package com.WEB2.backend.Service;


import com.WEB2.backend.Model.Tournament;
import com.WEB2.backend.Repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    public Tournament getTournamentByHash(String hash){
        return tournamentRepository.findByTournamenthash(hash);
    }
}
