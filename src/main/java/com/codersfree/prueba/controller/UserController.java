package com.codersfree.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codersfree.prueba.dto.UserDto;
import com.codersfree.prueba.model.User;
import com.codersfree.prueba.repository.UserRepository;
import com.codersfree.prueba.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
   private UserService userService;

    public UserController(UserRepository userRepository) {
        
    }

    @GetMapping("/users")
    public String index(Model model) {

        List<User> users = userService.findAll();

        model.addAttribute("users", users);

        return "users/index";
    }

    @GetMapping("/users/{id}")
    public String show(Model model, @PathVariable Long id) {

        model.addAttribute("user", userService.findById(id));

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

        userService.save(userDto);

        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String edit(Model model, @PathVariable Long id) {
        User user = userService.findById(id);

        model.addAttribute("id", id);
        model.addAttribute("userDto", new UserDto(user.getName(), user.getEmail()));
        
        return "users/edit";
    }

    @PutMapping("/users/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute UserDto userDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "users/edit";
        }
        userService.update(id, userDto);
        return "redirect:/users";
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
