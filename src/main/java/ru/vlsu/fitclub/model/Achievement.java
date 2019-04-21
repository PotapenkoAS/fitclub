package ru.vlsu.fitclub.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Achievement {
    private int achievementId;
    private Integer activityId;
    private String description;
    private byte[] image;
    private Integer weight;
    private Integer speed;
    private Integer distance;
    private Integer count;

    @Id
    @Column(name = "achievement_id", nullable = false)
    public int getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(int achievementId) {
        this.achievementId = achievementId;
    }

    @Basic
    @Column(name = "activity_id")
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Basic
    @Column(name = "description", length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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
    @Column(name = "speed")
    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @Basic
    @Column(name = "distance")
    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Achievement that = (Achievement) o;
        return achievementId == that.achievementId &&
                Objects.equals(activityId, that.activityId) &&
                Objects.equals(description, that.description) &&
                Arrays.equals(image, that.image) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(speed, that.speed) &&
                Objects.equals(distance, that.distance) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(achievementId, activityId, description, weight, speed, distance, count);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
