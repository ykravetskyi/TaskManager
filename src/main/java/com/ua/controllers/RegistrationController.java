package com.ua.controllers;

import com.ua.entity.Role;
import com.ua.entity.User;
import com.ua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String reg() {
        return "registration";
    }

    @PostMapping("/reg/new_u")
    public String regUser(@RequestParam("username") String username,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password, @RequestParam("password_confirm") String password_confirm) {
        User user = User.builder()
                .username(username)
                .password(password)
                .role(Role.ROLE_USER)
                .email(email)
                .build();

        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activation(code);

        if (isActivated) {
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "User successfully activated");
        } else {
            model.addAttribute("messageType", "danger");
            model.addAttribute("message", "Activation code is not found!");
        }

        return "login";
    }
}
