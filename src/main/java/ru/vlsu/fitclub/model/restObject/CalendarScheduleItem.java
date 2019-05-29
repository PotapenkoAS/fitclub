package ru.vlsu.fitclub.model.restObject;

import java.util.GregorianCalendar;

public class CalendarScheduleItem {

    private String text;
    private int trainingId;
    private int groupId;
    private GregorianCalendar date;
    private int count;


    public CalendarScheduleItem() {
    }

    public CalendarScheduleItem(GregorianCalendar date, String text, int trainingId, int groupId) {
        this.date = date;
        this.text = text;
        if (trainingId != 0) {
            this.trainingId = trainingId;
        } else if (groupId != 0) {
            this.groupId = groupId;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
}
