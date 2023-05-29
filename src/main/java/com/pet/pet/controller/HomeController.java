package com.pet.pet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/adoption")
    public String adoption() {
        return "adoption";
    }

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @RequestMapping("/adoptionForm")
    public String adoptionForm() {
        return "adoptionForm";
    }

    @RequestMapping("/interaction")
    public String dashboardForm() {
        return "interaction";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
