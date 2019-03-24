package ru.vlsu.fitclub.serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.User;
import ru.vlsu.fitclub.repositories.UserRepository;

import java.util.ArrayList;

@Service
public class UserService {

    private UserRepository ur;
    private final Environment env;

    @Autowired
    public UserService(UserRepository ur, Environment env) {
        this.ur = ur;
        this.env = env;
    }

    public ArrayList<String> userValidation(User user) {

        int loginLength = env.getProperty("security.login.min.length", Integer.class, 6);
        int passLength = env.getProperty("security.password.min.length", Integer.class, 6);

        ArrayList<String> errorList = new ArrayList<>();
        if (user.getLogin().length() < loginLength) {
            errorList.add("Логин слишком короткий");
        }
        if (user.getPassword().length() < passLength) {
            errorList.add("Пароль слишком короткий");
        }
        if(ur.existsByLogin(user.getLogin())){
            errorList.add("Логин занят");
        }
        return errorList;
    }
}
