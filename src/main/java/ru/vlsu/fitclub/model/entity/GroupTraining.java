package ru.vlsu.fitclub.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "group_training", schema = "fitness_club")
public class GroupTraining {
    private int groupId;
    private String groupName;
    private String groupDescription;
    private Time timeBegin;
    private Time timeEnd;
    private Integer regularity;
    private Collection<GroupClients> groupClientsByGroupId;
    private Trainer trainerByTrainerId;
    private Activity activityByActivityId;
    private Date date;
    private Integer trainerId;
    private Integer activityId;

    @Id
    @Column(name = "group_id", nullable = false)
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "group_description", length = -1)
    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    @Basic
    @Column(name = "time_begin")
    public Time getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Time timeBegin) {
        this.timeBegin = timeBegin;
    }

    @Basic
    @Column(name = "time_end")
    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Basic
    @Column(name = "regularity")
    public Integer getRegularity() {
        return regularity;
    }

    public void setRegularity(Integer regularity) {
        this.regularity = regularity;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupTraining that = (GroupTraining) o;
        return groupId == that.groupId &&
                Objects.equals(groupName, that.groupName) &&
                Objects.equals(groupDescription, that.groupDescription) &&
                Objects.equals(timeBegin, that.timeBegin) &&
                Objects.equals(timeEnd, that.timeEnd) &&
                Objects.equals(regularity, that.regularity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, groupName, groupDescription, timeBegin, timeEnd, regularity);
    }

    @OneToMany(mappedBy = "groupTrainingByGroupId")
    public Collection<GroupClients> getGroupClientsByGroupId() {
        return groupClientsByGroupId;
    }

    public void setGroupClientsByGroupId(Collection<GroupClients> groupClientsByGroupId) {
        this.groupClientsByGroupId = groupClientsByGroupId;
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
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id", insertable = false, updatable = false)
    public Activity getActivityByActivityId() {
        return activityByActivityId;
    }

    public void setActivityByActivityId(Activity activityByActivityId) {
        this.activityByActivityId = activityByActivityId;
    }

    @Basic
    @Column(name = "trainer_id")
    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    @Basic
    @Column(name = "activity_id")
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
}
