package ru.vlsu.fitclub.model.entity;

import ru.vlsu.fitclub.model.stuff.ActivitySpecializationKey;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(ActivitySpecializationKey.class)
@Table(name = "activity_specialization", schema = "fitness_club")
public class ActivitySpecialization {
    private int activityId;
    private int specializationId;
    private Activity activityByActivityId;
    private Specialization specializationBySpecializationId;

    @Basic
    @Id
    @Column(name = "activity_id", nullable = false)
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    @Basic
    @Id
    @Column(name = "specialization_id", nullable = false)
    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivitySpecialization that = (ActivitySpecialization) o;
        return activityId == that.activityId &&
                specializationId == that.specializationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityId, specializationId);
    }

    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id", nullable = false, updatable = false, insertable = false)
    public Activity getActivityByActivityId() {
        return activityByActivityId;
    }

    public void setActivityByActivityId(Activity activityByActivityId) {
        this.activityByActivityId = activityByActivityId;
    }

    @ManyToOne
    @JoinColumn(name = "specialization_id", referencedColumnName = "specialization_id", nullable = false, updatable = false, insertable = false)
    public Specialization getSpecializationBySpecializationId() {
        return specializationBySpecializationId;
    }

    public void setSpecializationBySpecializationId(Specialization specializationBySpecializationId) {
        this.specializationBySpecializationId = specializationBySpecializationId;
    }
}
