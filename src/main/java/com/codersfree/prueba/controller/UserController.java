package com.codersfree.prueba.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codersfree.prueba.dto.UserDto;
import com.codersfree.prueba.model.User;

import jakarta.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/users")
    public String index(Model model) {

        User user1 = User.builder().id(1L).name("Alice").email("alice@example.com").build();
        User user2 = User.builder().id(2L).name("Bob").email("bob@example.com").build();
        User user3 = User.builder().id(3L).name("Charlie").email("charlie@example.com").build();

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
    public String create(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "users/create";
    }

    @PostMapping("/users")
    public String store(@Valid @ModelAttribute UserDto userDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "users/create";
        }
        return "redirect:/users";
    }

}
