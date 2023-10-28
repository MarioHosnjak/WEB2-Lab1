package com.WEB2.backend.Repository;

import com.WEB2.backend.Model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
    Tournament findByTournamenthash(String hash);

    @Query(value = "SELECT * FROM tournament natural join usertable WHERE tournament.userid = usertable.userid AND usertable.username = :username", nativeQuery=true)
    List<Object[]> findByUsername(@Param("username") String username);

}