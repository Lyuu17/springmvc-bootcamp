package net.aspanc.bootcamp.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    @RequestMapping("/")
    private String index(Model model) {
        model.addAttribute("helloWorld", "Hello World");
        return "index";
    }
}
