package ru.vlsu.fitclub.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class User {
    private int userId;
    private String login;
    private String password;
    private String role;
    private Collection<Admin> adminsByUserId;
    private Collection<Client> clientsByUserId;
    private Collection<Trainer> trainersByUserId;

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, login, password, role);
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Admin> getAdminsByUserId() {
        return adminsByUserId;
    }

    public void setAdminsByUserId(Collection<Admin> adminsByUserId) {
        this.adminsByUserId = adminsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Client> getClientsByUserId() {
        return clientsByUserId;
    }

    public void setClientsByUserId(Collection<Client> clientsByUserId) {
        this.clientsByUserId = clientsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Trainer> getTrainersByUserId() {
        return trainersByUserId;
    }

    public void setTrainersByUserId(Collection<Trainer> trainersByUserId) {
        this.trainersByUserId = trainersByUserId;
    }
}
