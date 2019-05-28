package ru.vlsu.fitclub.model.restObject;

import java.util.Calendar;

public class CalendarScheduleItem {

    private String text;
    private int trainingId;
    private int groupId;
    private Calendar date;

    public CalendarScheduleItem(Calendar date, String text, int trainingId, int groupId) {
        this.date = date;
        this.text = text;
        if (trainingId != 0) {
            this.trainingId = trainingId;
        } else if (groupId != 0) {
            this.groupId = groupId;
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
