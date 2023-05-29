package net.aspanc.bootcamp.springmvc.services;

import net.aspanc.bootcamp.springmvc.entities.GameModel;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface GameService {

    Page<GameModel> findAll(int page, int size);

    Optional<GameModel> findById(Long id);

    Page<GameModel> findByTitle(String title, int page, int size);

    void deleteById(Long id);

    GameModel save(GameModel entity);
}
