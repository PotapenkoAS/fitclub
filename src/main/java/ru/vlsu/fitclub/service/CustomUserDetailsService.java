package ru.vlsu.fitclub.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.CustomUserDetails;
import ru.vlsu.fitclub.model.entity.User;
import ru.vlsu.fitclub.repository.UserRepository;

import javax.xml.crypto.dsig.SignatureProperties;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository ur;

    @Autowired
    public CustomUserDetailsService(UserRepository ur) {
        this.ur = ur;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user;
        try {
            if ((user = ur.findByLogin(username)) != null) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
                return new CustomUserDetails(user.getLogin(), "{noop}" + user.getPassword(), true, true, true
                        , true,authorities , user.getUserId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UsernameNotFoundException(username);
    }
}

