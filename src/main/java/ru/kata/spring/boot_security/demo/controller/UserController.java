package ru.kata.spring.boot_security.demo.controller;

import java.security.Principal;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.userdetails.UserDetailsService;


@Controller
@RequestMapping("/user")
public class UserController {
    private final UserDetailsService userDetailsService;

    public UserController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("")
    public String index(Principal principal, Model model) {
        model.addAttribute("currentUser", userDetailsService.loadUserByUsername(principal.getName()));
        return "user/index";
    }
}