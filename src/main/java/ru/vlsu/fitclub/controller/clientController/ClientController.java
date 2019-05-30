package ru.vlsu.fitclub.controller.clientController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.vlsu.fitclub.model.CustomUserDetails;
import ru.vlsu.fitclub.model.entity.Client;
import ru.vlsu.fitclub.service.ClientService;
import ru.vlsu.fitclub.service.UserService;

import java.io.IOException;
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
        int id = userService.getCurrentUserId();
        return "redirect:/client/" + id;
    }

    @GetMapping("/client/{userId}")
    public String getClientId(@PathVariable int userId, Model model) {
        Client client = clientService.getClientByUserId(userId);
        String avatar = Base64.getEncoder().encodeToString(client.getAvatar());
        model.addAttribute("avatar", avatar);
        model.addAttribute("client", client);
        model.addAttribute("imageList", clientService.getAchievementImagesAndTitleByClient(client));
        return "client/client_site";
    }

    @PostMapping("/client/{userId}")
    public String postClientId(@PathVariable("userId") int userId, @RequestParam("file") MultipartFile avatar, Model model) throws IOException {
        Client client = clientService.getClientByUserId(userId);
        if (!avatar.isEmpty()) {
            byte[] bytes = avatar.getBytes();
            client.setAvatar(bytes);
            clientService.save(client);
        }
        return "redirect:/client/" + userId;
    }
}
