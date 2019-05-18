package ru.vlsu.fitclub.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.CustomUserDetails;
import ru.vlsu.fitclub.model.entity.User;

import java.util.ArrayList;

@Service
public class LoginService {

    public void login(User user) {
        ArrayList<GrantedAuthority> auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        CustomUserDetails cud = new CustomUserDetails(user.getLogin(), "{noop}" + user.getPassword(), true, true, true
                , true,auths , user.getUserId());
        Authentication auth = new UsernamePasswordAuthenticationToken(cud, null, auths);
        SecurityContextHolder.getContext().setAuthentication(auth);

    }
}
