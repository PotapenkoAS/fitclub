package ru.vlsu.fitclub.controller.registrationController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.vlsu.fitclub.model.Client;
import ru.vlsu.fitclub.model.User;
import ru.vlsu.fitclub.service.LoginService;
import ru.vlsu.fitclub.service.RegistrationService;
import ru.vlsu.fitclub.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class RegistrationController {

    private RegistrationService regService;
    private UserService userService;
    private LoginService loginService;

    @Autowired
    public RegistrationController(RegistrationService regService, UserService userService, LoginService loginService) {
        this.regService = regService;
        this.userService = userService;
        this.loginService = loginService;
    }

    @GetMapping("/registration")
    public String getRegistrationPage(User user) {
        return "login/registration";
    }


    @PostMapping("/registration")
    public String postRegistrationPage(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            return "login/registration";
        }
        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:/post_registration";
    }

    @GetMapping("/post_registration")
    public ModelAndView getPostRegistrationPage(User user) {
        return new ModelAndView("login/post_registration", "user", user);
    }

    @PostMapping("/post_registration")
    public String postPostRegistrationPage(Client client, String password, String login, Model model) {
        User user = new User(login, password, "CLIENT");
        ArrayList<String> errorList = regService.saveClient(client, user);
        if (errorList.isEmpty()) {
            loginService.login(user);
            return "redirect:/home";
        }
        model.addAttribute("errorList", errorList);
        return "login/post_registration";
    }
}
