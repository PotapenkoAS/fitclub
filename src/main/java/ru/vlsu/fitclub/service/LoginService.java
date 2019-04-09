package ru.vlsu.fitclub.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.User;

import java.util.ArrayList;

@Service
public class LoginService {

    public void login(User user) {
        ArrayList<GrantedAuthority> auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, auths);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
