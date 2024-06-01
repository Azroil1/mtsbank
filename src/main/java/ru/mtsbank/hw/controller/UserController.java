package ru.mtsbank.hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username, @RequestParam String password, Model model) {
        // Логика проверки имени пользователя и пароля
        // Для простоты, здесь просто добавляется сообщение
        if ("user".equals(username) && "password".equals(password)) {
            model.addAttribute("message", "Успешный вход");
            return "index";
        } else {
            model.addAttribute("error", "Неверное имя пользователя или пароль");
            return "login";
        }
    }
}
