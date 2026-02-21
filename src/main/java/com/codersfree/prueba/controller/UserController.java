package com.codersfree.prueba.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codersfree.prueba.model.User;

@Controller
public class UserController {

    @GetMapping("/users")
    public String index(Model model) {

        User user1 = new User(1L, "Alice", "alice@example.com");
        User user2 = new User(2L, "Bob", "bob@example.com");
        User user3 = new User(3L, "Charlie", "charlie@example.com");

        List<User> users = List.of(user1, user2, user3);

        model.addAttribute("users", users);
        return "users/index";
    }

    @GetMapping("/users/{id}")
    public String show(Model model, @PathVariable Long id) {
        model.addAttribute("userId", id);
        return "users/show";
    }

    @GetMapping("/users/create")
    public String create() {
        return "users/create"; 
    }

    @PostMapping("/users")
    public String store(String name, String email) {
        return "users/create";
    }

}
