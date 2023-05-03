package net.aspanc.bootcamp.springmvc.controllers;

import net.aspanc.bootcamp.springmvc.facades.GameFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class GameController {

    @Resource
    private GameFacade gameFacade;

    @RequestMapping("/")
    private String index(Model model) {
        model.addAttribute("gameList", gameFacade.findAll());
        return "index";
    }

    @RequestMapping("/game/{id}")
    private String game(@PathVariable("id") Long id, Model model) {
        gameFacade.findById(id).ifPresent(gameFound -> model.addAttribute("game", gameFound));
        return "game";
    }

    @RequestMapping("/game/delete/{id}")
    private String deleteGame(@PathVariable("id") Long id, Model model) {
        gameFacade.findById(id).ifPresent(gameDto -> gameFacade.deleteById(id));
        return "redirect:/";
    }

    @RequestMapping("/game/search")
    private String searchGame(@RequestParam("title") String title, Model model) {
        model.addAttribute("gameList", gameFacade.findByTitle(title));
        return "index";
    }
}
