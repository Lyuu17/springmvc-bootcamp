package net.aspanc.bootcamp.springmvc.services.impl;

import net.aspanc.bootcamp.springmvc.entities.GameModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameServiceImplIntegrationTest {

    private final String TEST_GAME_NAME = "AAAAAAAAAAABBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCC";
    private final String TEST_GAME_DESCRIPTION = "Test description";
    private final Integer TEST_GAME_STEAMID = 1337;

    private final Integer CURRENT_PAGE = 0;
    private final Integer MAX_GAMES_PER_PAGE = 10;

    @Resource
    private GameServiceImpl gameService;

    private GameModel gameModelTest;

    @Before
    public void setUp() {
        gameModelTest = new GameModel();
        gameModelTest.setTitle(TEST_GAME_NAME);
        gameModelTest.setDescription(TEST_GAME_DESCRIPTION);
        gameModelTest.setSteamId(TEST_GAME_STEAMID);

        gameService.save(gameModelTest);
    }

    @After
    public void cleanUp() {
        gameService.findById(gameModelTest.getId())
                .ifPresent(gameModel -> gameService.deleteById(gameModel.getId()));
    }

    @Test
    public void create() {
        Assert.assertNotNull(gameModelTest.getId());
        Assert.assertEquals(TEST_GAME_NAME, gameModelTest.getTitle());
        Assert.assertEquals(TEST_GAME_DESCRIPTION, gameModelTest.getDescription());
        Assert.assertEquals(TEST_GAME_STEAMID, gameModelTest.getSteamId());
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void createNull() {
        gameService.save(null);
    }

    @Test(expected = ConstraintViolationException.class)
    public void createTitleNull() {
        GameModel model = new GameModel();
        model.setDescription(TEST_GAME_DESCRIPTION);
        model.setSteamId(TEST_GAME_STEAMID);
        gameService.save(model);
    }

    @Test
    public void retrieve() {
        Assert.assertTrue(gameService.findById(gameModelTest.getId()).isPresent());
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void retrieveNull() {
        gameService.findById(null);
    }

    @Test
    public void retrieveNotExists() {
        Assert.assertTrue(gameService.findById(Long.MAX_VALUE).isEmpty());
    }

    @Test
    public void findAll() {
        Assert.assertFalse(gameService.findAll(CURRENT_PAGE, MAX_GAMES_PER_PAGE).isEmpty());
    }

    @Test
    public void findByTitle() {
        Assert.assertTrue(gameService.findByTitle("BB", CURRENT_PAGE, MAX_GAMES_PER_PAGE).getContent().contains(gameModelTest));
    }

    @Test
    public void update() {
        gameModelTest.setDescription("New description");

        Assert.assertEquals(gameModelTest.getDescription(), gameService.save(gameModelTest).getDescription());
    }

    @Test
    public void delete() {
        gameService.deleteById(gameModelTest.getId());

        Assert.assertFalse(gameService.findById(gameModelTest.getId()).isPresent());
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void deleteNull() {
        gameService.deleteById(null);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteNotExists() {
        gameService.deleteById(Long.MAX_VALUE);
    }
}
