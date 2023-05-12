package net.aspanc.bootcamp.springmvc.controllers;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @Resource
    private MessageSource messageSource;

    @GetMapping("/login")
    public String index(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", messageSource.getMessage("label.login.invalidcredentials", null, LocaleContextHolder.getLocale()));
        }

        if (logout != null) {
            model.addAttribute("message", messageSource.getMessage("label.logout.message", null, LocaleContextHolder.getLocale()));
        }

        return "login";
    }
}
