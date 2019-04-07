package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.Client;
import ru.vlsu.fitclub.model.User;
import ru.vlsu.fitclub.repositories.UserRepository;
import java.util.ArrayList;

@Service
public class RegistrationService {
    private UserRepository ur;
    private UserService userService;

    @Autowired
    public RegistrationService(UserRepository ur, UserService userService) {
        this.ur = ur;
        this.userService = userService;
    }

    public ArrayList<String> save(User user) {
        ArrayList<String> errorList = userService.loginPasswordValidation(user.getLogin(),user.getPassword());
        if(errorList.isEmpty()) {
            if(ur.existsByLogin(user.getLogin())) {
                errorList.add("Пользователь с таким именем уже существует");
            }
        }
        if (errorList.isEmpty()) {
            user.setRole("CLIENT");
            ur.save(user);
        }
        return errorList;
    }

    public ArrayList<String> saveClient(Client client){

    }
}
