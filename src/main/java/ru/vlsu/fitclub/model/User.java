package ru.vlsu.fitclub.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class User {

    private int userId;
    @NotNull
    @Size(min = 6, max = 50, message = "Длина от 6 до 50 символов")
    private String login;
    @NotNull
    @Size(min = 6, max = 50, message = "Длина от 6 до 50 символов")
    private String password;
    private String role;
    private Admin adminByUserId;
    private Client clientByUserId;
    private Trainer trainerByUserId;

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "login", nullable = false, unique = true)
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

    public void setAdminByUserId(Admin adminByUserId) {
        this.adminByUserId = adminByUserId;
    }

    @OneToOne(mappedBy = "userByUserId")
    public Client getClientByUserId() {
        return clientByUserId;
    }

    public void setClientByUserId(Client clientByUserId) {
        this.clientByUserId = clientByUserId;
    }

    @OneToOne(mappedBy = "userByUserId")
    public Trainer getTrainerByUserId() {
        return trainerByUserId;
    }

    public void setTrainerByUserId(Trainer trainerByUserId) {
        this.trainerByUserId = trainerByUserId;
    }

}
