package ru.vlsu.fitclub.controller.clientController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.vlsu.fitclub.model.CustomUserDetails;
import ru.vlsu.fitclub.model.entity.Client;
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
        int id = ((CustomUserDetails) (SecurityContextHolder.getContext().getAuthentication().getPrincipal())).getUserId();
        return "redirect:/client/" + id;
    }

    @GetMapping("/client/{userId}")
    public String getClientId(@PathVariable int userId, Model model) {
        Client client = clientService.getClientByUserId(userId);
        String avatar = Base64.getEncoder().encodeToString(client.getAvatar());
        model.addAttribute("avatar", avatar);
        model.addAttribute("client", client);
        model.addAttribute("imageList", clientService.getClientAchievementsImages(client));
        return "client/client_site";
    }

}
