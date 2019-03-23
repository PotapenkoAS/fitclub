package ru.vlsu.fitclub.model;

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
    private Integer userId;
    private Collection<Group> groupsByTrainerId;
    private User userByUserId;
    private Collection<TrainerSpecialization> trainerSpecializationsByTrainerId;
    private Collection<Training> trainingsByTrainerId;

    @Id
    @Column(name = "trainer_id")
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
    @Column(name = "phone")
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
                Objects.equals(phone, trainer.phone) &&
                Objects.equals(userId, trainer.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerId, surname, name, patronymic, email, phone, userId);
    }

    @OneToMany(mappedBy = "trainerByTrainerId")
    public Collection<Group> getGroupsByTrainerId() {
        return groupsByTrainerId;
    }

    public void setGroupsByTrainerId(Collection<Group> groupsByTrainerId) {
        this.groupsByTrainerId = groupsByTrainerId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id",insertable=false, updatable=false)
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
}
