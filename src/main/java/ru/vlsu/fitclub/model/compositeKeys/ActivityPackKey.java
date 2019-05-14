package ru.vlsu.fitclub.model.compositeKeys;

import java.io.Serializable;

public class ActivityPackKey implements Serializable {
    private int activityId;
    private int activityPackId;

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getActivityPackId() {
        return activityPackId;
    }

    public void setActivityPackId(int activityPackId) {
        this.activityPackId = activityPackId;
    }
}
