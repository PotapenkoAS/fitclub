package ru.vlsu.fitclub.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Specialization {
    private int specializationId;
    private String name;
    private String description;
    private Collection<TrainerSpecialization> trainerSpecializationsBySpecializationId;
    private Collection<ActivitySpecialization> activitySpecializationsBySpecializationId;

    @Id
    @Column(name = "specialization_id", nullable = false)
    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
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
    @Column(name = "description", length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialization that = (Specialization) o;
        return specializationId == that.specializationId &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specializationId, name, description);
    }

    @OneToMany(mappedBy = "specializationBySpecializationId")
    public Collection<TrainerSpecialization> getTrainerSpecializationsBySpecializationId() {
        return trainerSpecializationsBySpecializationId;
    }

    public void setTrainerSpecializationsBySpecializationId(Collection<TrainerSpecialization> trainerSpecializationsBySpecializationId) {
        this.trainerSpecializationsBySpecializationId = trainerSpecializationsBySpecializationId;
    }

    @OneToMany(mappedBy = "specializationBySpecializationId")
    public Collection<ActivitySpecialization> getActivitySpecializationsBySpecializationId() {
        return activitySpecializationsBySpecializationId;
    }

    public void setActivitySpecializationsBySpecializationId(Collection<ActivitySpecialization> activitySpecializationsBySpecializationId) {
        this.activitySpecializationsBySpecializationId = activitySpecializationsBySpecializationId;
    }
}
