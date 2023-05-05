package net.aspanc.bootcamp.springmvc.controllers;

import net.aspanc.bootcamp.springmvc.dtos.GameDto;
import net.aspanc.bootcamp.springmvc.facades.GameFacade;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@Controller
public class GameController {

    @Resource
    private GameFacade gameFacade;

    @Resource
    private MessageSource messageSource;

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
    private String deleteGame(@PathVariable("id") Long id, Model model, RedirectAttributes attr) {
        attr.addFlashAttribute("alertMessageSuccess", messageSource.getMessage("alert.game.deleted.success", null, LocaleContextHolder.getLocale()));
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
    private String addGame(@Validated @ModelAttribute("game") GameDto gameDto, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "editgame";
        }

        attr.addFlashAttribute("alertMessageSuccess", messageSource.getMessage("alert.game.added.success", null, LocaleContextHolder.getLocale()));
        return "redirect:/game/" + gameFacade.save(gameDto).getId();
    }

    @GetMapping("/game/edit/{id}")
    private String editGameForm(Model model, @PathVariable("id") Long id) {
        gameFacade.findById(id).ifPresent(gameFound -> model.addAttribute("game", gameFound));
        return "editgame";
    }

    @PostMapping("/game/edit/{id}")
    private String editGame(@Validated @ModelAttribute("game") GameDto gameDto, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "editgame";
        }

        attr.addFlashAttribute("alertMessageSuccess", messageSource.getMessage("alert.game.updated.success", null, LocaleContextHolder.getLocale()));
        return "redirect:/game/" + gameFacade.save(gameDto).getId();
    }
}
