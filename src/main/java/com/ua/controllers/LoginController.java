package com.ua.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String log() {
        return "login";
    }

    @PostMapping("/login")
    public String ok(Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName(); //get logged in username
//        User user = userService.findByUsername(name);
//        model.addAttribute("user",user);
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/login";
    }


}
