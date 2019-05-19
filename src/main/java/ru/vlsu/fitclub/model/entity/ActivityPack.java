package ru.vlsu.fitclub.model.entity;

import ru.vlsu.fitclub.model.compositeKey.ActivityPackKey;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(ActivityPackKey.class)
@Table(name = "activity_pack", schema = "fitness_club")
public class ActivityPack {
    private Integer activityId;
    private Integer activityPackId;
    private Activity activityByActivityId;
    private Pack packByActivityPackId;

    @Basic
    @Id
    @Column(name = "activity_id")
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Basic
    @Id
    @Column(name = "activity_pack_id")
    public Integer getActivityPackId() {
        return activityPackId;
    }

    public void setActivityPackId(Integer activityPackId) {
        this.activityPackId = activityPackId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityPack that = (ActivityPack) o;
        return Objects.equals(activityId, that.activityId) &&
                Objects.equals(activityPackId, that.activityPackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityId, activityPackId);
    }

    @ManyToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id", insertable = false, updatable = false)
    public Activity getActivityByActivityId() {
        return activityByActivityId;
    }

    public void setActivityByActivityId(Activity activityByActivityId) {
        this.activityByActivityId = activityByActivityId;
    }

    @ManyToOne
    @JoinColumn(name = "activity_pack_id", referencedColumnName = "pack_id", insertable = false, updatable = false)
    public Pack getPackByActivityPackId() {
        return packByActivityPackId;
    }

    public void setPackByActivityPackId(Pack packByActivityPackId) {
        this.packByActivityPackId = packByActivityPackId;
    }
}
