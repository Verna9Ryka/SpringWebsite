package com.example.website.controllers;

import com.example.website.interfaces.SiteUsersInterface;
import com.example.website.models.SiteUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegPageController {
    @Autowired
    public SiteUsersInterface siteUsersInterface;

    @PostMapping("/regPage")
    public String addSiteUser(@RequestParam String login, @RequestParam String password, @RequestParam String nickname, Model model) {
        SiteUsers siteUsers = new SiteUsers(login, password, nickname);
        siteUsersInterface.save(siteUsers);
        return "redirect:/";
    }
}
