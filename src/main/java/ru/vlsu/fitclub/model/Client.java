package ru.vlsu.fitclub.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Client {
    private int clientId;
    private String name;
    private String patronymic;
    private String surname;
    private String email;
    private String phone;
    private Integer userId;
    private Integer weight;
    private Integer height;
    private byte[] avatar;
    private Date birthDate;
    private User userByUserId;
    private Collection<ClientAchieves> clientAchievesByClientId;
    private Collection<GroupClients> groupClientsByClientId;
    private Collection<Subscription> subscriptionsByClientId;
    private Collection<Training> trainingsByClientId;

    @Id
    @Column(name = "client_id", nullable = false)
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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
    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "weight")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "height")
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Basic
    @Column(name = "avatar")
    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId == client.clientId &&
                Objects.equals(name, client.name) &&
                Objects.equals(patronymic, client.patronymic) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(email, client.email) &&
                Objects.equals(phone, client.phone) &&
                Objects.equals(userId, client.userId) &&
                Objects.equals(weight, client.weight) &&
                Objects.equals(height, client.height) &&
                Arrays.equals(avatar, client.avatar) &&
                Objects.equals(birthDate, client.birthDate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(clientId, name, patronymic, surname, email, phone, userId, weight, height, birthDate);
        result = 31 * result + Arrays.hashCode(avatar);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "clientByClientId")
    public Collection<ClientAchieves> getClientAchievesByClientId() {
        return clientAchievesByClientId;
    }

    public void setClientAchievesByClientId(Collection<ClientAchieves> clientAchievesByClientId) {
        this.clientAchievesByClientId = clientAchievesByClientId;
    }

    @OneToMany(mappedBy = "clientByClientId")
    public Collection<GroupClients> getGroupClientsByClientId() {
        return groupClientsByClientId;
    }

    public void setGroupClientsByClientId(Collection<GroupClients> groupClientsByClientId) {
        this.groupClientsByClientId = groupClientsByClientId;
    }

    @OneToMany(mappedBy = "clientByClientId")
    public Collection<Subscription> getSubscriptionsByClientId() {
        return subscriptionsByClientId;
    }

    public void setSubscriptionsByClientId(Collection<Subscription> subscriptionsByClientId) {
        this.subscriptionsByClientId = subscriptionsByClientId;
    }

    @OneToMany(mappedBy = "clientByClientId")
    public Collection<Training> getTrainingsByClientId() {
        return trainingsByClientId;
    }

    public void setTrainingsByClientId(Collection<Training> trainingsByClientId) {
        this.trainingsByClientId = trainingsByClientId;
    }
}
