package net.aspanc.bootcamp.springmvc.controllers;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.facades.GameFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class GameController {

    @Resource
    private GameFacade gameFacade;

    @GetMapping("/")
    private String index(Model model) {
        model.addAttribute("gameList", gameFacade.findAll());
        return "index";
    }

    @GetMapping("/game/{id}")
    private String game(@PathVariable("id") Long id, Model model) {
        gameFacade.findById(id).ifPresent(gameFound -> model.addAttribute("game", gameFound));
        return "game";
    }

    @GetMapping("/game/delete/{id}")
    private String deleteGame(@PathVariable("id") Long id, Model model) {
        gameFacade.findById(id).ifPresent(gameDto -> gameFacade.deleteById(id));
        return "redirect:/";
    }

    @GetMapping("/game/search")
    private String searchGame(@RequestParam("title") String title, Model model) {
        model.addAttribute("gameList", gameFacade.findByTitle(title));
        return "index";
    }

    @GetMapping("/game/add")
    private String addGameForm(Model model) {
        model.addAttribute("game", new GameDto());
        return "addgame";
    }

    @PostMapping("/game/add")
    private String addGame(Model model, @ModelAttribute("game") GameDto gameDto) {
        return "redirect:/game/" + gameFacade.save(gameDto).getId();
    }
}
