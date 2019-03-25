package ru.vlsu.fitclub.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.User;
import ru.vlsu.fitclub.repositories.UserRepository;

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
        if((user = ur.findByLogin(username))!=null){
            return org.springframework.security.core.userdetails.User
                    .builder()
                    .username(user.getLogin())
                    .password(user.getPassword())
                    .roles(user.getRole())
                    .authorities(user.getRole())
                    .build();
        }
        throw new UsernameNotFoundException(username);
    }

}
