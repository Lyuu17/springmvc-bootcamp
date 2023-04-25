package net.aspanc.bootcamp.springmvc.services;

import net.aspanc.bootcamp.springmvc.entities.GameModel;

import java.util.List;
import java.util.Optional;

public interface GameService {

    List<GameModel> findAll();

    Optional<GameModel> findById(Long id);

    List<GameModel> findByTitle(String title);

    void deleteById(Long id);

    GameModel save(GameModel entity);
}
