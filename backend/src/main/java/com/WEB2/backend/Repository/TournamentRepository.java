package com.WEB2.backend.Repository;

import com.WEB2.backend.Model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
    Tournament findByTournamenthash(String hash);
}