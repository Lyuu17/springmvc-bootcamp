package net.aspanc.bootcamp.springmvc.services.impl;

import net.aspanc.bootcamp.springmvc.daos.GameDao;
import net.aspanc.bootcamp.springmvc.entities.GameModel;
import net.aspanc.bootcamp.springmvc.services.GameService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Resource
    private GameDao gameDao;

    @Override
    public Page<GameModel> findAll(int page, int size) {
        return gameDao.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<GameModel> findById(Long id) {
        return gameDao.findById(id);
    }

    @Override
    public Page<GameModel> findByTitle(String title, int page, int size) {
        return gameDao.findByTitleContainingIgnoreCase(title, PageRequest.of(page, size));
    }

    @Override
    public void deleteById(Long id) {
        gameDao.deleteById(id);
    }

    @Override
    public GameModel save(GameModel game) {
        return gameDao.save(game);
    }
}
