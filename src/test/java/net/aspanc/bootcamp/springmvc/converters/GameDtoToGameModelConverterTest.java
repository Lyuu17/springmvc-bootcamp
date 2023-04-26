package net.aspanc.bootcamp.springmvc.converters;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.entities.GameModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;

public class GameDtoToGameModelConverterTest {

    private final String TEST_GAME_TITLE = "Game Test";
    private final String TEST_GAME_DESCRIPTION = "Description Test";
    private final Integer TEST_GAME_STEAMID = 1337;

    private final Converter<GameDto, GameModel> converter = new GameDtoToGameModelConverter();

    private GameDto gameDto;

    @Before
    public void setUp() {
        gameDto = new GameDto();
        gameDto.setId(Long.MIN_VALUE);
        gameDto.setTitle(TEST_GAME_TITLE);
        gameDto.setDescription(TEST_GAME_DESCRIPTION);
        gameDto.setSteamId(TEST_GAME_STEAMID);
    }

    @Test
    public void conversionTest() {
        GameModel gameModel = converter.convert(gameDto);

        Assert.assertEquals(gameDto.getId(), gameModel.getId());
        Assert.assertEquals(gameDto.getTitle(), gameModel.getTitle());
        Assert.assertEquals(gameDto.getDescription(), gameModel.getDescription());
        Assert.assertEquals(gameDto.getSteamId(), gameModel.getSteamId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void conversionTestNull() {
        converter.convert(null);
    }
}
