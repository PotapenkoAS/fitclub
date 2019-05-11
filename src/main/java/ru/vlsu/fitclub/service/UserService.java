package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.CustomUserDetails;
import ru.vlsu.fitclub.model.entity.User;
import ru.vlsu.fitclub.repository.UserRepository;

import java.util.ArrayList;
import java.util.regex.Pattern;

@Service
public class UserService {

    private UserRepository ur;

    @Autowired
    public UserService(UserRepository ur) {
        this.ur = ur;
    }

    public User getUserByLogin(String login){
        return ur.findByLogin(login);
    }

    ArrayList<String> loginPasswordValidation(String login, String password) {
        int loginMinLength = 6;
        int passMinLength = 6;

        ArrayList<String> errorList = new ArrayList<>();
        if (login.length() < loginMinLength) {
            errorList.add("Логин слишком короткий");
        }
        if (password.length() < passMinLength) {
            errorList.add("Пароль слишком короткий");
        }
        return errorList;
    }

    public int getCurrentUserId(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((CustomUserDetails) principal).getUserId();
    }

    public String userExistsByLoginValidation(String login) {
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
