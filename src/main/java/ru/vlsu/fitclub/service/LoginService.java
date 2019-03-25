package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.User;
import ru.vlsu.fitclub.repositories.UserRepository;

import java.util.ArrayList;

@Service
public class LoginService {

    private UserService us;
    private UserRepository ur;
    private CustomUserDetailsService userDetailsService;

    @Autowired
    public LoginService(UserService us, UserRepository ur, CustomUserDetailsService userDetailsService) {
        this.us = us;
        this.ur = ur;
        this.userDetailsService = userDetailsService;
    }

    public ArrayList<String> loginUser(User user) {
        ArrayList<String> errorList = us.loginPasswordValidation(user.getLogin(), user.getPassword());
        if (errorList.isEmpty()) {
            if (!ur.existsByLoginAndPassword(user.getLogin(), user.getPassword())) {
                errorList.add("Неверный логин или пароль");
            } else {
                UserDetails userDetails = userDetailsService.loadUserByUsername(user.getLogin());
                System.out.println(userDetails.getUsername() + " --- " + userDetails.getPassword());
                for (GrantedAuthority item : userDetails.getAuthorities()) {
                    System.out.println("----" + item.toString());
                }
            }
        }
        return errorList;

    }
}
