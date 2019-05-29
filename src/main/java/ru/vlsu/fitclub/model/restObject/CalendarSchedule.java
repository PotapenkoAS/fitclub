package ru.vlsu.fitclub.model.restObject;

import javafx.util.Pair;

import java.util.ArrayList;

public class CalendarSchedule {

    private ArrayList<Pair<String, CalendarScheduleItem>> days;

    public CalendarSchedule() {
        days = new ArrayList<>();
        days.add(new Pair<>("MONDAY", new CalendarScheduleItem()));
        days.add(new Pair<>("TUESDAY", new CalendarScheduleItem()));
        days.add(new Pair<>("WEDNESDAY", new CalendarScheduleItem()));
        days.add(new Pair<>("THURSDAY", new CalendarScheduleItem()));
        days.add(new Pair<>("FRIDAY", new CalendarScheduleItem()));
        days.add(new Pair<>("SATURDAY", new CalendarScheduleItem()));
        days.add(new Pair<>("SUNDAY", new CalendarScheduleItem()));
    }

    public ArrayList<Pair<String, CalendarScheduleItem>> getDays() {
        return days;
    }

    public void setDays(ArrayList<Pair<String, CalendarScheduleItem>> days) {
        this.days = days;
    }

    public void setItem(int dayOfWeek, CalendarScheduleItem item) {
        CalendarScheduleItem tmp = this.getDays().get(dayOfWeek).getValue();
        tmp.setDate(item.getDate());
        tmp.setCount(item.getCount());
        tmp.setText(item.getText());
        tmp.setTrainingId(item.getTrainingId());
        tmp.setGroupId(item.getGroupId());
    }
}
