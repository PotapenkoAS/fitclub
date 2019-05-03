package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.repository.UserRepository;

import java.util.ArrayList;
import java.util.regex.Pattern;

@Service
public class UserService {

    private final Environment env;
    private UserRepository ur;

    @Autowired
    public UserService(Environment env, UserRepository ur) {
        this.env = env;
        this.ur = ur;
    }

    ArrayList<String> loginPasswordValidation(String login, String password) {
        int loginMinLength = env.getProperty("security.login.min.length", Integer.class, 6);
        int passMinLength = env.getProperty("security.password.min.length", Integer.class, 6);

        ArrayList<String> errorList = new ArrayList<>();
        if (login.length() < loginMinLength) {
            errorList.add("Логин слишком короткий");
        }
        if (password.length() < passMinLength) {
            errorList.add("Пароль слишком короткий");
        }
        return errorList;
    }

    public String userExistsValidation(String login) {
        if (ur.existsByLogin(login)) {
            return "Пользователь с таким именем уже существует";
        }
        return null;
    }

    public String emailValidate(String email) {

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return null;
        if (!pat.matcher(email).matches()) {
            return "Некорректный email";
        }
        return null;
    }

}
