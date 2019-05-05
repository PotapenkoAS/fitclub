package ru.vlsu.fitclub.model;

import java.sql.Date;
import java.sql.Time;

public class GroupSchedule {

    private Date date;
    private Time timeBegin;
    private Time timeEnd;
    private String trainerName;
    private int trainerId;
    private String activityName;
    private int activityId;

    public GroupSchedule(Date date, Time timeBegin, Time timeEnd, String trainerName, int trainerId, String activityName, int activityId) {
        this.date = date;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.trainerName = trainerName;
        this.trainerId = trainerId;
        this.activityName = activityName;
        this.activityId = activityId;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Time timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}