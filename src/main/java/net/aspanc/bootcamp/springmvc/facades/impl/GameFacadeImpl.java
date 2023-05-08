package net.aspanc.bootcamp.springmvc.facades.impl;

import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamStorefront;
import com.ibasco.agql.protocols.valve.steam.webapi.pojos.StoreAppDetails;
import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.dtos.SteamGameDto;
import net.aspanc.bootcamp.springmvc.entities.GameModel;
import net.aspanc.bootcamp.springmvc.facades.GameFacade;
import net.aspanc.bootcamp.springmvc.services.GameService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GameFacadeImpl implements GameFacade {

    @Resource
    private GameService gameService;

    @Resource
    private Converter<GameDto, GameModel> gameDtoToGameModelConverter;

    @Resource
    private Converter<GameModel, GameDto> gameModelToGameDtoConverter;

    @Resource
    private SteamStorefront steamStorefront;

    @Resource
    private Converter<StoreAppDetails, SteamGameDto> storeAppDetailsGameSteamDataDtoConverter;

    @Override
    public List<GameDto> findAll() {
        return gameService.findAll()
                .stream()
                .map(gameModelToGameDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GameDto> findById(Long id) {
        return gameService.findById(id)
                .map(gameModelToGameDtoConverter::convert);
    }

    @Override
    public List<GameDto> findByTitle(String title) {
        return gameService.findByTitle(title)
                .stream()
                .map(gameModelToGameDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        gameService.deleteById(id);
    }

    @Override
    public GameDto save(GameDto game) {
        return gameModelToGameDtoConverter.convert(gameService.save(gameDtoToGameModelConverter.convert(game)));
    }

    public SteamGameDto getGameDetails(Integer steamId) {
        return storeAppDetailsGameSteamDataDtoConverter.convert(steamStorefront.getAppDetails(steamId).join());
    }
}
