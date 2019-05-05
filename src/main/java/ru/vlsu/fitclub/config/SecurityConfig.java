package ru.vlsu.fitclub.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/client/**").hasRole("CLIENT")
                .antMatchers("/trainer/**").hasAnyRole("ADMIN", "CLIENT", "TRAINER")
                .antMatchers("/login").permitAll()
                .antMatchers("/home").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/post_registration").permitAll()
                .antMatchers("/group_training").permitAll()
                .antMatchers("/content/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureForwardUrl("/login?error=true");
    }
}