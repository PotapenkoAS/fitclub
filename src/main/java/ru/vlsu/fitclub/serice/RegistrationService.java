package ru.vlsu.fitclub.serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.User;
import ru.vlsu.fitclub.repositories.UserRepository;

import java.lang.reflect.Array;
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
        ArrayList<String> errorList = userService.userValidation(user);
        Iterable<User> list =ur.findAll();
        if (errorList.size() == 0) {
            user.setRole("Client");
            ur.save(user);
        }
        return errorList;

    }
}
