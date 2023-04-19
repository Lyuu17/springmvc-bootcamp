package net.aspanc.bootcamp.springmvc.daos;

import net.aspanc.bootcamp.springmvc.entities.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameDao extends JpaRepository<GameModel, Long> {

    List<GameModel> findByTitleContainingIgnoreCase(String title);
}
