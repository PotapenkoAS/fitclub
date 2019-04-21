package ru.vlsu.fitclub.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Group {
    private int groupId;
    private String groupName;
    private String groupDescription;
    private Integer trainerId;
    private Integer activityId;
    private Trainer trainerByTrainerId;
    private Activity activityByActivityId;
    private Collection<GroupClients> groupClientsByGroupId;

    @Id
    @Column(name = "group_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupId == group.groupId &&
                Objects.equals(groupName, group.groupName) &&
                Objects.equals(groupDescription, group.groupDescription) &&
                Objects.equals(trainerId, group.trainerId) &&
                Objects.equals(activityId, group.activityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, groupName, groupDescription, trainerId, activityId);
    }

    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "trainer_id", insertable=false, updatable=false)
    public Trainer getTrainerByTrainerId() {
        return trainerByTrainerId;
    }

    public void setTrainerByTrainerId(Trainer trainerByTrainerId) {
        this.trainerByTrainerId = trainerByTrainerId;
    }

    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id", insertable=false, updatable=false)
    public Activity getActivityByActivityId() {
        return activityByActivityId;
    }

    public void setActivityByActivityId(Activity activityByActivityId) {
        this.activityByActivityId = activityByActivityId;
    }

    @OneToMany(mappedBy = "groupByGroupId")
    public Collection<GroupClients> getGroupClientsByGroupId() {
        return groupClientsByGroupId;
    }

    public void setGroupClientsByGroupId(Collection<GroupClients> groupClientsByGroupId) {
        this.groupClientsByGroupId = groupClientsByGroupId;
    }
}
