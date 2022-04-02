package com.example.website.controllers;

import com.example.website.WebsiteApplication;
import com.example.website.interfaces.SiteUsersInterface;
import com.example.website.models.SiteUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class HomePageController {
    @Autowired
    public SiteUsersInterface siteUsersInterface;

    @GetMapping("/")
    public String homePageOpen(Model model) {
        model.addAttribute("title", "Главная страница");
        model.addAttribute("siteUserID", WebsiteApplication.getSiteUserID());
        return "homePage";
    }

    @GetMapping("/gamePage")
    public String gamePageOpen(Model model) {
        model.addAttribute("title", "Игровая страница");
        model.addAttribute("siteUserID", WebsiteApplication.getSiteUserID());
        return "gamePage";
    }

    @GetMapping("/infoPage")
    public String infoPageOpen(Model model) {
        model.addAttribute("title", "Информационная страница");
        model.addAttribute("siteUserID", WebsiteApplication.getSiteUserID());
        return "infoPage";
    }

    @GetMapping("/signInPage")
    public String signInPageOpen(Model model) {
        model.addAttribute("title", "Личный кабинет");
        return "signInPage";
    }

    @GetMapping("/accountPage/{id}")
    public String accountPageOpen(@PathVariable(value = "id") Long id, Model model) {
        if(!siteUsersInterface.existsById(id)){
            return "redirect:/";
        }
        Optional<SiteUsers> siteUser = siteUsersInterface.findById(id);
        ArrayList<SiteUsers> siteUserList = new ArrayList<>();
        siteUser.ifPresent(siteUserList::add);
        model.addAttribute("title", "Личный кабинет");
        model.addAttribute("siteUserID", WebsiteApplication.getSiteUserID());
        model.addAttribute("siteUserList", siteUserList);
        return "accountPage";
    }
}

