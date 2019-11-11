package com.ua.controllers;

import com.ua.entity.Task;
import com.ua.entity.User;
import com.ua.service.TaskService;
import com.ua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class TaskController {
    private final UserService userService;
    private final TaskService taskService;

    @Autowired
    public TaskController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/addTask")
    public String addTask() {
        return "addTask";
    }

    @PostMapping("/reg/new_task")
    public String regTask(Task task, Principal principal) {
        String name = principal.getName();
        User user = userService.findUserByUsername(name);
        taskService.save(task);
        task.setUser(user);
        taskService.save(task);
        return "redirect:/home";
    }

    @GetMapping("/delete/task/{id}")
    public String deleteTaskById(@PathVariable int id, Model model) {
        taskService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/task/{id}")
    public String editTaskById(@PathVariable int id, Model model) {
        Task task = taskService.findOne(id);
        model.addAttribute("task", task);
        return "edit";
    }

    @PostMapping("/task/{id}/edit")
    public String edit(@PathVariable int id, @RequestParam("new_name") String new_name,
                       @RequestParam("new_description") String new_description) {
        Task task = taskService.findOne(id);
        task.setName(new_name);
        task.setDescription(new_description);
        taskService.save(task);
        return "redirect:/home";
    }

    @GetMapping("/share/task/{id}")
    public String shareTask(@PathVariable int id, Model model) {
        Task task = taskService.findOne(id);
        model.addAttribute("task", task);
        return "share";
    }

    @PostMapping("/share/to_mail/{id}")
    public String shareEmail(@PathVariable int id, @RequestParam("email") String email) {
        User user = userService.findUserByEmail(email);
        Task task = taskService.findOne(id);
        task.setUser(user);
        taskService.save(task);
        return "redirect:/home";
    }
}
