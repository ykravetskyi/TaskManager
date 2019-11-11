package com.ua.controllers;

import com.ua.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final TaskService taskService;

    @Autowired
    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String ok() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String findAll(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "home";
    }
}
