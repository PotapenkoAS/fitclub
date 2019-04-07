package ru.vlsu.fitclub.controller.registrationController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.vlsu.fitclub.service.LoginService;

@Controller
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login/login";
    }

    @PostMapping("/login")
    public ModelAndView postLogin(@RequestParam(name = "error", required = false, defaultValue = "false") String error) {
        if (error.equals("true")) {
            return new ModelAndView("login/login", "errorList", "Неверное имя или пароль");
        } else return new ModelAndView("home/home");
    }
}

