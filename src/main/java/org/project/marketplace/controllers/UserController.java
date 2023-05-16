package org.project.marketplace.controllers;

import lombok.RequiredArgsConstructor;
import org.project.marketplace.entities.UserEntity;
import org.project.marketplace.exeptions.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(UserEntity user, Model model)
    {
        if (!userService.createUser(user))
        {
            model.addAttribute("errorMessage", "Пользователь с email: " + user.getLoginEmail() + " уже существует");
            return "registration";
        }
        else
        {
            userService.createUser(user);
        }
        return "/redirect:/login";
    }

    @GetMapping("/safety")
    public String safetyPage()
    {
        return "safety";
    }
}

