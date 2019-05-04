package ru.vlsu.fitclub.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Admin {
    private int adminId;
    private String surname;
    private String patronymic;
    private String name;
    private Integer userId;
    private User userByUserId;
    private Collection<Subscription> subscriptionsByAdminId;

    @Id
    @Column(name = "admin_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return adminId == admin.adminId &&
                Objects.equals(surname, admin.surname) &&
                Objects.equals(patronymic, admin.patronymic) &&
                Objects.equals(name, admin.name) &&
                Objects.equals(userId, admin.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, surname, patronymic, name, userId);
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "adminByAdminId")
    public Collection<Subscription> getSubscriptionsByAdminId() {
        return subscriptionsByAdminId;
    }

    public void setSubscriptionsByAdminId(Collection<Subscription> subscriptionsByAdminId) {
        this.subscriptionsByAdminId = subscriptionsByAdminId;
    }
}
