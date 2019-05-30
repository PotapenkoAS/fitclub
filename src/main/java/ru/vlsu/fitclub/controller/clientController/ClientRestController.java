package ru.vlsu.fitclub.controller.clientController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.fitclub.model.entity.Client;
import ru.vlsu.fitclub.service.ClientService;
import ru.vlsu.fitclub.service.UserService;

@RestController
public class ClientRestController {

    ClientService clientService;
    UserService userService;

    @Autowired
    public ClientRestController(ClientService clientService, UserService userService) {
        this.clientService = clientService;
        this.userService = userService;
    }


    @PostMapping("/client/update")
    public void updateClient(String name, String surname, String mail, float height, float weight) {
        Client client = clientService.getClientByUserId(userService.getCurrentUserId());
        client.setName(name);
        client.setSurname(surname);
        client.setEmail(mail);
        client.setHeight(height);
        client.setWeight(weight);
        clientService.save(client);
    }
}
