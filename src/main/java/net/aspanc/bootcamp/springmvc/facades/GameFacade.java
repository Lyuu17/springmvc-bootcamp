package net.aspanc.bootcamp.springmvc.facades;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.dtos.SteamGameDto;
import net.aspanc.bootcamp.springmvc.dtos.SteamGameNewsDto;

import java.util.List;
import java.util.Optional;

public interface GameFacade {

    List<GameDto> findAll();

    Optional<GameDto> findById(Long id);

    List<GameDto> findByTitle(String title);

    void deleteById(Long id);

    GameDto save(GameDto game);

    List<SteamGameNewsDto> getGameNews(Integer steamId);

    SteamGameDto getGameDetails(Integer steamId);
}
