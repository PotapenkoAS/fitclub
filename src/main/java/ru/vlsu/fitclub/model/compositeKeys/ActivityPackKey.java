package ru.vlsu.fitclub.model.compositeKeys;

import java.io.Serializable;

public class ActivityPackKey implements Serializable {
    private int activityId;
    private int packId;

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getPackId() {
        return packId;
    }

    public void setPackId(int packId) {
        this.packId = packId;
    }
}
