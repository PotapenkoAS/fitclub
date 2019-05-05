package ru.vlsu.fitclub.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.User;
import ru.vlsu.fitclub.repository.UserRepository;

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
                return org.springframework.security.core.userdetails.User
                        .builder()
                        .username(user.getLogin())
                        .password("{noop}" + user.getPassword())
                        .roles(user.getRole())
                        .build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        throw new UsernameNotFoundException(username);
    }
}

