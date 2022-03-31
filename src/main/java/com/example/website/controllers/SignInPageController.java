package com.example.website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInPageController {
    @GetMapping("/regPage")
    public String regPageOpen(Model model) {
        model.addAttribute("title", "Страница регистрации");
        return "regPage";
    }
}
