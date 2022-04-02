package com.example.website.controllers;

import com.example.website.WebsiteApplication;
import com.example.website.interfaces.SiteUsersInterface;
import com.example.website.models.SiteUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountPageController {
    @Autowired
    public SiteUsersInterface siteUsersInterface;

    //@PostMapping(value = "/accountPage/{id}", params = "updateButton")
    @RequestMapping(value="/accountPage/{id}", method= RequestMethod.POST, params="updateButton")
    public String updateSiteUser(@PathVariable(value = "id") Long id, @RequestParam String login, @RequestParam String password, @RequestParam String nickname, Model model) {
        SiteUsers siteUser = siteUsersInterface.findById(id).orElseThrow();
        siteUser.setLogin(login);
        siteUser.setPassword(password);
        siteUser.setNickname(nickname);
        siteUsersInterface.save(siteUser);
        return "redirect:/accountPage/" + WebsiteApplication.getSiteUserID();
    }

    //@PostMapping("/accountPage/{id}", params = "deleteButton")
    @RequestMapping(value="/accountPage/{id}", method= RequestMethod.POST, params="deleteButton")
    public String deleteSiteUser(@PathVariable(value = "id") Long id, Model model) {
        SiteUsers siteUser = siteUsersInterface.findById(id).orElseThrow();
        siteUsersInterface.delete(siteUser);
        return "redirect:/";
    }
}
