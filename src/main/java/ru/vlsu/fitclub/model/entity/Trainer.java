package ru.vlsu.fitclub.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Trainer {
    private int trainerId;
    private String surname;
    private String name;
    private String patronymic;
    private String email;
    private String phone;
    private Collection<GroupTraining> groupTrainingsByTrainerId;
    private User userByUserId;
    private Collection<TrainerSpecialization> trainerSpecializationsByTrainerId;
    private Collection<Training> trainingsByTrainerId;
    private Collection<Subscription> subscriptionsByTrainerId;
    private Integer userId;
    private byte[] avatar;
    private String shortDescription;
    private String fullDescription;
    private Double experience;
    private Double rating;

    @Transient
    private String encodedAvatar;

    @Transient
    public String getEncodedAvatar() {
        return encodedAvatar;
    }

    @Transient
    public void setEncodedAvatar(String encodedAvatar) {
        this.encodedAvatar = encodedAvatar;
    }

    @Id
    @Column(name = "trainer_id", nullable = false)
    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return trainerId == trainer.trainerId &&
                Objects.equals(surname, trainer.surname) &&
                Objects.equals(name, trainer.name) &&
                Objects.equals(patronymic, trainer.patronymic) &&
                Objects.equals(email, trainer.email) &&
                Objects.equals(phone, trainer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerId, surname, name, patronymic, email, phone);
    }

    @OneToMany(mappedBy = "trainerByTrainerId")
    public Collection<GroupTraining> getGroupTrainingsByTrainerId() {
        return groupTrainingsByTrainerId;
    }

    public void setGroupTrainingsByTrainerId(Collection<GroupTraining> groupTrainingsByTrainerId) {
        this.groupTrainingsByTrainerId = groupTrainingsByTrainerId;
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "trainerByTrainerId")
    public Collection<TrainerSpecialization> getTrainerSpecializationsByTrainerId() {
        return trainerSpecializationsByTrainerId;
    }

    public void setTrainerSpecializationsByTrainerId(Collection<TrainerSpecialization> trainerSpecializationsByTrainerId) {
        this.trainerSpecializationsByTrainerId = trainerSpecializationsByTrainerId;
    }

    @OneToMany(mappedBy = "trainerByTrainerId")
    public Collection<Training> getTrainingsByTrainerId() {
        return trainingsByTrainerId;
    }

    public void setTrainingsByTrainerId(Collection<Training> trainingsByTrainerId) {
        this.trainingsByTrainerId = trainingsByTrainerId;
    }

    @OneToMany(mappedBy = "trainerByTrainerId")
    public Collection<Subscription> getSubscriptionsByTrainerId() {
        return subscriptionsByTrainerId;
    }

    public void setSubscriptionsByTrainerId(Collection<Subscription> subscriptionsByTrainerId) {
        this.subscriptionsByTrainerId = subscriptionsByTrainerId;
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
    @Column(name = "avatar")
    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "short_description")
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Basic
    @Column(name = "full_description")
    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    @Basic
    @Column(name = "experience")
    public Double getExperience() {
        return experience;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
    }

    @Basic
    @Column(name = "rating")
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
