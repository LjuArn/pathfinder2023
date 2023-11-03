package com.example.pathfinder2023.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesControllers {

    @GetMapping("/pages/all")
    public String all(){
        return "all";
    }

    @GetMapping("/pages/moderators")
    public String moderatorPage(){
        return "moderators";
    }

    @GetMapping("/pages/admin")
    public String adminPage(){
        return "admin";
    }

}
