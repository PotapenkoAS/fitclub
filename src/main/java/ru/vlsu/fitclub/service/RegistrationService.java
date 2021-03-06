package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.fitclub.model.entity.Client;
import ru.vlsu.fitclub.model.entity.User;
import ru.vlsu.fitclub.repository.ClientRepository;
import ru.vlsu.fitclub.repository.UserRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

@Service
public class RegistrationService {
    private UserRepository ur;
    private ClientRepository cr;
    private UserService userService;

    @Autowired
    public RegistrationService(UserRepository ur, ClientRepository cr, UserService userService) {
        this.ur = ur;
        this.cr = cr;
        this.userService = userService;
    }

    @Transactional
    public ArrayList<String> saveClient(Client client, User user) {
        ArrayList<String> errorList = userService.loginPasswordValidation(user.getLogin(), user.getPassword());
        //TODO errorList.add(userService.emailValidate(client.getEmail()));
        //TODO errorList.add(userService.phoneValidate(client.getPhone()));
        if (errorList.isEmpty()) {
            if (!ur.existsByLogin(user.getLogin())) {
                user = ur.save(user);
            } else {
                errorList.add("Пользователь с таким именем уже существует");
                return errorList;
            }
        } else {
            return errorList;
        }
        client.setUserId(user.getUserId());
        try {
            byte[] avatar = Files.readAllBytes(new File("src/main/resources/static/content/1.png").toPath().toAbsolutePath());
            client.setAvatar(avatar);
        }catch (IOException e){
            e.printStackTrace();
        }
        cr.save(client);
        return errorList;
    }
}
