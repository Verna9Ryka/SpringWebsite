package com.example.website.controllers;

import com.example.website.interfaces.SiteUsersInterface;
import com.example.website.models.SiteUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String homePageOpen(Model model) {
        model.addAttribute("title", "Главная страница");
        return "homePage";
    }

    @GetMapping("/gamePage")
    public String gamePageOpen(Model model) {
        model.addAttribute("title", "Игровая страница");
        return "gamePage";
    }

    @GetMapping("/infoPage")
    public String infoPageOpen(Model model) {
        model.addAttribute("title", "Информационная страница");
        return "infoPage";
    }

    @GetMapping("/signInPage")
    public String signInPageOpen(Model model) {
        model.addAttribute("title", "Личный кабинет");
        return "signInPage";
    }
}

