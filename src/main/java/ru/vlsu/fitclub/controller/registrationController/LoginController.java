package ru.vlsu.fitclub.controller.registrationController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.vlsu.fitclub.model.User;
import ru.vlsu.fitclub.service.LoginService;

import java.util.ArrayList;

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
    public ModelAndView postLogin(String username,String password) {
        User user = new User(username,password,"CLIENT");
        ArrayList<String> errorList = loginService.loginUser(user);
        if (errorList.isEmpty()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("login/login", "errorList", errorList);
    }
}
