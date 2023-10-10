package com.WEB2.backend.Repository;

import com.WEB2.backend.Model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {
}