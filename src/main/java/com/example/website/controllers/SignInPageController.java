package com.example.website.controllers;

import com.example.website.WebsiteApplication;
import com.example.website.interfaces.SiteUsersInterface;
import com.example.website.models.SiteUsers;
import org.springframework.asm.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class SignInPageController {
    @Autowired
    public SiteUsersInterface siteUsersInterface;

    @GetMapping("/regPage")
    public String regPageOpen(Model model) {
        model.addAttribute("title", "Страница регистрации");
        return "regPage";
    }

    @PostMapping("/signInPage")
    public String signIn(@RequestParam String login, @RequestParam String password, Model model) {
        boolean compare = false;
        ArrayList<SiteUsers> siteUserList = (ArrayList<SiteUsers>) siteUsersInterface.findAll();
        for (SiteUsers siteUser:siteUserList) {
            if(siteUser.getLogin().equals(login) && siteUser.getPassword().equals(password))
            {
                WebsiteApplication.setSiteUserID(siteUser.getId());
                return "redirect:/accountPage/" + WebsiteApplication.getSiteUserID();
            }
        }
        if(!compare){
            return "redirect:/signInPage";
        }
        return "redirect:/";
    }
}
