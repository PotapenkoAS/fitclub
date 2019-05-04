package ru.vlsu.fitclub.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Achievement {
    private int achievementId;
    private Integer activityId;
    private String description;
    private double value;
    private byte[] image;
    private Activity activityByActivityId;
    private Collection<ClientAchieves> clientAchievesByAchievementId;

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
    @Column(name = "value", nullable = false, precision = 3)
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Achievement that = (Achievement) o;
        return achievementId == that.achievementId &&
                Double.compare(that.value, value) == 0 &&
                Objects.equals(activityId, that.activityId) &&
                Objects.equals(description, that.description) &&
                Arrays.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(achievementId, activityId, description, value);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id", insertable = false, updatable = false)
    public Activity getActivityByActivityId() {
        return activityByActivityId;
    }

    public void setActivityByActivityId(Activity activityByActivityId) {
        this.activityByActivityId = activityByActivityId;
    }

    @OneToMany(mappedBy = "achievementByAchievementId")
    public Collection<ClientAchieves> getClientAchievesByAchievementId() {
        return clientAchievesByAchievementId;
    }

    public void setClientAchievesByAchievementId(Collection<ClientAchieves> clientAchievesByAchievementId) {
        this.clientAchievesByAchievementId = clientAchievesByAchievementId;
    }
}
