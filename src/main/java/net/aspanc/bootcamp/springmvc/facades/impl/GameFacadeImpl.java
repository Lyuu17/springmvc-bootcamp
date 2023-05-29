package net.aspanc.bootcamp.springmvc.facades.impl;

import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamNews;
import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamStorefront;
import com.ibasco.agql.protocols.valve.steam.webapi.pojos.SteamNewsItem;
import com.ibasco.agql.protocols.valve.steam.webapi.pojos.StoreAppDetails;
import net.aspanc.bootcamp.springmvc.configurations.SteamAPIProperties;
import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.dtos.SteamGameDto;
import net.aspanc.bootcamp.springmvc.dtos.SteamGameNewsDto;
import net.aspanc.bootcamp.springmvc.entities.GameModel;
import net.aspanc.bootcamp.springmvc.facades.GameFacade;
import net.aspanc.bootcamp.springmvc.services.GameService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
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
    private SteamNews steamNews;

    @Resource
    private Converter<StoreAppDetails, SteamGameDto> storeAppDetailsGameSteamDataDtoConverter;

    @Resource
    private Converter<SteamNewsItem, SteamGameNewsDto> steamNewsToGameSteamNewsDtoConverter;

    @Resource
    private SteamAPIProperties steamAPIProperties;

    @Override
    public Page<GameDto> findAll(int page, int size) {
        return gameService.findAll(page, size)
                .map(gameModelToGameDtoConverter::convert);
    }

    @Override
    public Optional<GameDto> findById(Long id) {
        return gameService.findById(id)
                .map(gameModelToGameDtoConverter::convert);
    }

    @Override
    public Page<GameDto> findByTitle(String title, int page, int size) {
        return gameService.findByTitle(title, page, size)
                .map(gameModelToGameDtoConverter::convert);
    }

    @Override
    public void deleteById(Long id) {
        gameService.deleteById(id);
    }

    @Override
    public GameDto save(GameDto game) {
        return gameModelToGameDtoConverter.convert(gameService.save(gameDtoToGameModelConverter.convert(game)));
    }

    @Override
    public List<SteamGameNewsDto> getGameNews(Integer steamId) {
        return steamNews.getNewsForApp(steamId, steamAPIProperties.getNewsMaxContentLength(), -1, steamAPIProperties.getNewsMaxItems(), "").join()
                .stream()
                .map(steamNewsToGameSteamNewsDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public SteamGameDto getGameDetails(Integer steamId) {
        return storeAppDetailsGameSteamDataDtoConverter.convert(steamStorefront.getAppDetails(steamId).join());
    }
}
