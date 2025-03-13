package com.example.demowebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    
    private List<User> users = new ArrayList<>();
    private long idCounter = 0;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user, Model model) {
        try {
            user.setId(++idCounter);
            users.add(user);
            model.addAttribute("message", "User added successfully!");
        } catch (Exception e) {
            model.addAttribute("message", "Error adding user: " + e.getMessage());
        }
        model.addAttribute("users", users);
        return "index";
    }
}