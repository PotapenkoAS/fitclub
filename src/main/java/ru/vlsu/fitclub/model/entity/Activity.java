package ru.vlsu.fitclub.model.entity;

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
    private Collection<Achievement> achievementsByActivityId;
    private Collection<GroupTraining> groupTrainingsByActivityId;
    private Collection<Training> trainingsByActivityId;
    private byte[] image;
    private Collection<ActivitySpecialization> activitySpecializationsByActivityId;
    private Collection<ActivityPack> activityPacksByActivityId;

    @Id
    @Column(name = "activity_id", nullable = false)
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
    public Collection<Achievement> getAchievementsByActivityId() {
        return achievementsByActivityId;
    }

    public void setAchievementsByActivityId(Collection<Achievement> achievementsByActivityId) {
        this.achievementsByActivityId = achievementsByActivityId;
    }

    @OneToMany(mappedBy = "activityByActivityId")
    public Collection<GroupTraining> getGroupTrainingsByActivityId() {
        return groupTrainingsByActivityId;
    }

    public void setGroupTrainingsByActivityId(Collection<GroupTraining> groupTrainingsByActivityId) {
        this.groupTrainingsByActivityId = groupTrainingsByActivityId;
    }

    @OneToMany(mappedBy = "activityByActivityId")
    public Collection<Training> getTrainingsByActivityId() {
        return trainingsByActivityId;
    }

    public void setTrainingsByActivityId(Collection<Training> trainingsByActivityId) {
        this.trainingsByActivityId = trainingsByActivityId;
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @OneToMany(mappedBy = "activityByActivityId")
    public Collection<ActivitySpecialization> getActivitySpecializationsByActivityId() {
        return activitySpecializationsByActivityId;
    }

    public void setActivitySpecializationsByActivityId(Collection<ActivitySpecialization> activitySpecializationsByActivityId) {
        this.activitySpecializationsByActivityId = activitySpecializationsByActivityId;
    }

    @OneToMany(mappedBy = "activityByActivityId")
    public Collection<ActivityPack> getActivityPacksByActivityId() {
        return activityPacksByActivityId;
    }

    public void setActivityPacksByActivityId(Collection<ActivityPack> activityPacksByActivityId) {
        this.activityPacksByActivityId = activityPacksByActivityId;
    }
}
