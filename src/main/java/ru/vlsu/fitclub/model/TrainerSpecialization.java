package ru.vlsu.fitclub.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "trainer_specialization", schema = "fitness_club")
public class TrainerSpecialization {
    private Integer trainerId;
    private Integer specializationId;
    private Trainer trainerByTrainerId;
    private Specialization specializationBySpecializationId;

    @Basic
    @Id
    @Column(name = "trainer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    @Basic
    @Column(name = "specialization_id")
    public Integer getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Integer specializationId) {
        this.specializationId = specializationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainerSpecialization that = (TrainerSpecialization) o;
        return Objects.equals(trainerId, that.trainerId) &&
                Objects.equals(specializationId, that.specializationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerId, specializationId);
    }

    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "trainer_id", insertable = false, updatable = false)
    public Trainer getTrainerByTrainerId() {
        return trainerByTrainerId;
    }

    public void setTrainerByTrainerId(Trainer trainerByTrainerId) {
        this.trainerByTrainerId = trainerByTrainerId;
    }

    @ManyToOne
    @JoinColumn(name = "specialization_id", referencedColumnName = "specialization_id", insertable = false, updatable = false)
    public Specialization getSpecializationBySpecializationId() {
        return specializationBySpecializationId;
    }

    public void setSpecializationBySpecializationId(Specialization specializationBySpecializationId) {
        this.specializationBySpecializationId = specializationBySpecializationId;
    }
}
