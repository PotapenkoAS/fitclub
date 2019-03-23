package ru.vlsu.fitclub.serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.config.Configuration;
import ru.vlsu.fitclub.model.User;
import ru.vlsu.fitclub.repositories.UserRepository;

import java.util.ArrayList;

@Service
public class UserService {

    private UserRepository ur;

    @Autowired
    public UserService(UserRepository ur) {
        this.ur = ur;
    }

    public ArrayList<String> userValidation(User user) {
        ArrayList<String> errorList = new ArrayList<>();
        if (user.getLogin().length() < Configuration.USER_LOGIN_MIN_LENGTH) {
            errorList.add("Логин слишком короткий");
        }
        if (user.getPassword().length() < Configuration.USER_PASSWORD_MIN_LENGTH) {
            errorList.add("Пароль слишком короткий");
        }
        if(ur.existsByLogin(user.getLogin())){
            errorList.add("Логин занят");
        }
        return errorList;
    }
}
