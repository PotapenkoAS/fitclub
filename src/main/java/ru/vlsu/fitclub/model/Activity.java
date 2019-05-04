package ru.vlsu.fitclub.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Activity {

    private int activityId;
    private String name;
    private Integer priceForTrain;
    private Integer priceForWeek;
    private Integer priceForMonth;
    private Integer priceForYear;
    private Byte isGroup;
    private String description;
    private Collection<Group> groupsByActivityId;
    private Collection<Training> trainingsByActivityId;
    private Collection<Achievement> achievementsByActivityId;

    @Id
    @Column(name = "activity_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
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
    @Column(name = "price_for_train")
    public Integer getPriceForTrain() {
        return priceForTrain;
    }

    public void setPriceForTrain(Integer priceForTrain) {
        this.priceForTrain = priceForTrain;
    }

    @Basic
    @Column(name = "price_for_week")
    public Integer getPriceForWeek() {
        return priceForWeek;
    }

    public void setPriceForWeek(Integer priceForWeek) {
        this.priceForWeek = priceForWeek;
    }

    @Basic
    @Column(name = "price_for_month")
    public Integer getPriceForMonth() {
        return priceForMonth;
    }

    public void setPriceForMonth(Integer priceForMonth) {
        this.priceForMonth = priceForMonth;
    }

    @Basic
    @Column(name = "price_for_year")
    public Integer getPriceForYear() {
        return priceForYear;
    }

    public void setPriceForYear(Integer priceForYear) {
        this.priceForYear = priceForYear;
    }

    @Basic
    @Column(name = "is_group")
    public Byte getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(Byte isGroup) {
        this.isGroup = isGroup;
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
        Activity activity = (Activity) o;
        return activityId == activity.activityId &&
                Objects.equals(name, activity.name) &&
                Objects.equals(priceForTrain, activity.priceForTrain) &&
                Objects.equals(priceForWeek, activity.priceForWeek) &&
                Objects.equals(priceForMonth, activity.priceForMonth) &&
                Objects.equals(priceForYear, activity.priceForYear) &&
                Objects.equals(isGroup, activity.isGroup) &&
                Objects.equals(description, activity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityId, name, priceForTrain, priceForWeek, priceForMonth, priceForYear, isGroup, description);
    }

    @OneToMany(mappedBy = "activityByActivityId")
    public Collection<Group> getGroupsByActivityId() {
        return groupsByActivityId;
    }

    public void setGroupsByActivityId(Collection<Group> groupsByActivityId) {
        this.groupsByActivityId = groupsByActivityId;
    }

    @OneToMany(mappedBy = "activityByActivityId")
    public Collection<Training> getTrainingsByActivityId() {
        return trainingsByActivityId;
    }

    public void setTrainingsByActivityId(Collection<Training> trainingsByActivityId) {
        this.trainingsByActivityId = trainingsByActivityId;
    }

    @OneToMany(mappedBy = "activityByActivityId")
    public Collection<Achievement> getAchievementsByActivityId() {
        return achievementsByActivityId;
    }

    public void setAchievementsByActivityId(Collection<Achievement> achievementsByActivityId) {
        this.achievementsByActivityId = achievementsByActivityId;
    }
}
