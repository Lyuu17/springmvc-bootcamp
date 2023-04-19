package net.aspanc.bootcamp.springmvc.services.impl;

import net.aspanc.bootcamp.springmvc.entities.GameModel;
import net.aspanc.bootcamp.springmvc.daos.GameDao;
import net.aspanc.bootcamp.springmvc.services.GameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Resource
    private GameDao gameDao;

    @Override
    public List<GameModel> findAll() {
        return gameDao.findAll();
    }

    @Override
    public Optional<GameModel> findById(long id) {
        return gameDao.findById(id);
    }

    @Override
    public List<GameModel> findByTitle(String title) {
        return gameDao.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public void deleteById(long id) {
        gameDao.deleteById(id);
    }

    @Override
    public void save(GameModel game) {
        gameDao.save(game);
    }
}
