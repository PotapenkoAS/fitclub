package ru.vlsu.fitclub.controller.registrationController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin() {
        return "login/login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam(name = "error", required = false, defaultValue = "false") String error, Model model) {
        if (error.equals("true")) {
            model.addAttribute("errorList","Неверное имя или пароль");
            return "login/login";
        }
        return null;
    }
}

