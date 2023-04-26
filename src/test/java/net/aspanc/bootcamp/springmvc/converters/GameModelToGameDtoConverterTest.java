package net.aspanc.bootcamp.springmvc.converters;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.entities.GameModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;

public class GameModelToGameDtoConverterTest {

    private final String TEST_GAME_TITLE = "Game Test";
    private final String TEST_GAME_DESCRIPTION = "Description Test";
    private final Integer TEST_GAME_STEAMID = 1337;

    private final Converter<GameModel, GameDto> converter = new GameModelToGameDtoConverter();

    private GameModel gameModel;

    @Before
    public void setUp() {
        gameModel = new GameModel();
        gameModel.setId(Long.MIN_VALUE);
        gameModel.setTitle(TEST_GAME_TITLE);
        gameModel.setDescription(TEST_GAME_DESCRIPTION);
        gameModel.setSteamId(TEST_GAME_STEAMID);
    }

    @Test
    public void conversionTest() {
        GameDto gameDto = converter.convert(gameModel);

        Assert.assertEquals(gameModel.getId(), gameDto.getId());
        Assert.assertEquals(gameModel.getTitle(), gameDto.getTitle());
        Assert.assertEquals(gameModel.getDescription(), gameDto.getDescription());
        Assert.assertEquals(gameModel.getSteamId(), gameDto.getSteamId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void conversionTestNull() {
        converter.convert(null);
    }
}
