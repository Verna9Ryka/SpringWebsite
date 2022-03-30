package com.example.website.controllers;

import com.example.website.interfaces.SiteUsersInterface;
import com.example.website.models.SiteUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @Autowired
    private SiteUsersInterface siteUsersInterface;

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
        Iterable<SiteUsers> siteUsers = siteUsersInterface.findAll();
        for (SiteUsers el:siteUsers) {
            System.out.println(el.getLogin());
            System.out.println(el.getPassword());
        }
        model.addAttribute("title", "Личный кабинет");
        model.addAttribute("siteUsers", siteUsers);
        return "loginAccountPage";
    }

}

