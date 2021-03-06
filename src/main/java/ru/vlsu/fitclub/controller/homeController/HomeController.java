package ru.vlsu.fitclub.controller.homeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vlsu.fitclub.model.entity.User;
import ru.vlsu.fitclub.repository.UserRepository;

@Controller
public class HomeController {

    private UserRepository users;

    @Autowired
    public HomeController(UserRepository users) {
        this.users = users;
    }

    @GetMapping("/greetings")
    public String helloWorld(@RequestParam(name = "name", required = false, defaultValue = "Motherfucker") String name, Model model) {
        Iterable<User> list = users.findAll();
        model.addAttribute("name", name);
        model.addAttribute("list", list);
        return "greeting";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:home";
    }

    @GetMapping("/home")
    public String getHome() {
        return "home/home";
    }
}
