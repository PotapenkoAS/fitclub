package ru.vlsu.fitclub.controller.clientController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.vlsu.fitclub.model.Client;
import ru.vlsu.fitclub.service.ClientService;
import ru.vlsu.fitclub.service.UserService;

import java.util.Base64;

@Controller
public class ClientController {

    private ClientService clientService;
    private UserService userService;

    @Autowired
    public ClientController(ClientService clientService, UserService userService) {
        this.clientService = clientService;
        this.userService = userService;
    }

    @GetMapping("/client")
    public String getClient() {
        Object user;
        if ((user = SecurityContextHolder.getContext().getAuthentication().getPrincipal()) instanceof UserDetails) {
            int id = userService.getUserByLogin(((UserDetails) user).getUsername()).getUserId();
            return "redirect:/client/" + id;
        }
        return "home/home";
    }

    @GetMapping("/client/{id}")
    public String getClientId(@PathVariable int id, Model model) {
        Client client = clientService.getClientByUserId(id);
        String avatar = Base64.getEncoder().encodeToString(client.getAvatar());
        model.addAttribute("avatar", avatar);
        model.addAttribute("client", client);
        model.addAttribute("imageList", clientService.getClientAchievementsImages(client));
        return "client/client_site";
    }

}
