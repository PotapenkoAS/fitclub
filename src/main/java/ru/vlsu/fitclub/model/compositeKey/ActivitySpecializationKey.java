package ru.vlsu.fitclub.model.compositeKey;


import java.io.Serializable;

public class ActivitySpecializationKey implements Serializable {
    private int activityId;
    private int specializationId;

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }
}
