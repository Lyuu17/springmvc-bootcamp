package net.aspanc.bootcamp.springmvc.facades;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.dtos.SteamGameDto;
import net.aspanc.bootcamp.springmvc.dtos.SteamGameNewsDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface GameFacade {

    Page<GameDto> findAll(int page, int size);

    Optional<GameDto> findById(Long id);

    Page<GameDto> findByTitle(String title, int page, int size);

    void deleteById(Long id);

    GameDto save(GameDto game);

    List<SteamGameNewsDto> getGameNews(Integer steamId);

    SteamGameDto getGameDetails(Integer steamId);
}
