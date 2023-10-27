package com.WEB2.backend.Service;

import com.WEB2.backend.Model.Scoringsystem;
import com.WEB2.backend.Repository.ScoringsystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScoringsystemService {

    @Autowired
    private ScoringsystemRepository scoringsystemRepository;

    public Optional<Scoringsystem> findBySportname(String sportname){
        return scoringsystemRepository.findById(sportname);
    }

    public Iterable<Scoringsystem> getAllScoringsystems(){
        return scoringsystemRepository.findAll();
    }
}
