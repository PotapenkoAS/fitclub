package ru.vlsu.fitclub.controller.registrationController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.vlsu.fitclub.model.Client;
import ru.vlsu.fitclub.model.User;
import ru.vlsu.fitclub.service.LoginService;
import ru.vlsu.fitclub.service.RegistrationService;
import ru.vlsu.fitclub.service.UserService;

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
    public String getRegistrationPage(Model model) {
        model.addAttribute("User", null);
        model.addAttribute("ValidationError", null);
        return "login/registration";
    }


    @PostMapping("/registration")
    public String postRegistrationPage(User user, RedirectAttributes redirectAttributes, Model model) {
        ArrayList<String> errorList = userService.loginPasswordValidation(user.getLogin(), user.getPassword());
        String tmp = userService.userExistsValidation(user.getLogin());
        if (tmp != null) {
            errorList.add(tmp);
        }
        if (errorList.isEmpty()) {
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/post_registration";
        }
        model.addAttribute("errorList", errorList);
        return "login/registration";
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
