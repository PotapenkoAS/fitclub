package ru.vlsu.fitclub.controller.homeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vlsu.fitclub.model.User;
import ru.vlsu.fitclub.repositories.UserRepository;

@Controller
public class MainController {

    private UserRepository users;

    @Autowired
    public MainController(UserRepository users) {
        this.users = users;
    }

    @GetMapping("/greetings")
    public String helloWorld(@RequestParam(name = "name", required = false, defaultValue = "Motherfucker") String name, Model model) {
        model.addAttribute("name", name);
        Iterable<User> list = users.findAll();
        model.addAttribute("list", list);
        return "greeting";
    }

    @GetMapping("/")
    public String getHome() {
        return "home/home";

    }
}
