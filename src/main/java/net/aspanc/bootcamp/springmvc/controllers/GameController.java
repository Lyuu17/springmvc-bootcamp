package net.aspanc.bootcamp.springmvc.controllers;

import net.aspanc.bootcamp.springmvc.facades.GameFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
