package com.example.website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", "Главная страница");
        return "homePage";
    }

    @GetMapping("/gamePage")
    public String gamePage(Model model) {
        model.addAttribute("title", "Игровая страница");
        return "gamePage";
    }

    @GetMapping("/informationPage")
    public String informationPage(Model model) {
        model.addAttribute("title", "Информационная страница");
        return "informationPage";
    }

    @GetMapping("/loginAccountPage")
    public String loginAccountPage(Model model) {
        model.addAttribute("title", "Личный кабинет");
        return "loginAccountPage";
    }

}

