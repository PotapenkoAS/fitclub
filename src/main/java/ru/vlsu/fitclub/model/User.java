package ru.vlsu.fitclub.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    private int userId;
    private String login;
    private String password;
    private String role;
    private Admin adminByUserId;
    private Client clientByUserId;
    private Trainer trainerByUserId;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "login", nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role", length = 20)
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

    @OneToOne(mappedBy = "userByUserId")
    public Admin getAdminByUserId() {
        return adminByUserId;
    }

    public void setAdminByUserId(Admin adminsByUserId) {
        this.adminByUserId = adminsByUserId;
    }

    @OneToOne(mappedBy = "userByUserId")
    public Client getClientByUserId() {
        return clientByUserId;
    }

    public void setClientByUserId(Client clientsByUserId) {
        this.clientByUserId = clientsByUserId;
    }

    @OneToOne(mappedBy = "userByUserId")
    public Trainer getTrainerByUserId() {
        return trainerByUserId;
    }

    public void setTrainerByUserId(Trainer trainersByUserId) {
        this.trainerByUserId = trainersByUserId;
    }


    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(){ }
}
