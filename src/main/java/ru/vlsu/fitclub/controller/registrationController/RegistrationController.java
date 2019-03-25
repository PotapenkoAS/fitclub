package ru.vlsu.fitclub.controller.registrationController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.vlsu.fitclub.model.User;
import ru.vlsu.fitclub.service.RegistrationService;

import java.util.ArrayList;

@Controller
public class RegistrationController {

    private RegistrationService regService;


    @Autowired
    public RegistrationController(RegistrationService regService) {
        this.regService = regService;
    }

    @GetMapping("/registration")
    public ModelAndView getRegistrationPage(Model model) {
        model.addAttribute("User", null);

        return new ModelAndView("login/registration","ValidationError",null);
    }


    @PostMapping("/registration")
    public ModelAndView postRegistrationPage(User user) {
        ArrayList<String> errorList = regService.save(user);
        if (errorList.size()==0) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("login/registration", "errorList", errorList);
    }
}
