package com.codersfree.prueba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping("/cursos")
    public String cursos() {
        return "cursos";
    }

}
