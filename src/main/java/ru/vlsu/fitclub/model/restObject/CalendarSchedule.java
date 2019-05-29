package ru.vlsu.fitclub.model.restObject;

import java.util.HashMap;

public class CalendarSchedule {

    private HashMap<String, CalendarScheduleItem> days;

    public CalendarSchedule() {
        days = new HashMap<>();
        days.put("MONDAY", new CalendarScheduleItem());
        days.put("TUESDAY", new CalendarScheduleItem());
        days.put("WEDNESDAY", new CalendarScheduleItem());
        days.put("THURSDAY", new CalendarScheduleItem());
        days.put("FRIDAY", new CalendarScheduleItem());
        days.put("SATURDAY", new CalendarScheduleItem());
        days.put("SUNDAY", new CalendarScheduleItem());
    }

    public HashMap<String, CalendarScheduleItem> getDays() {
        return days;
    }

    public void setDays(HashMap<String, CalendarScheduleItem> days) {
        this.days = days;
    }
}
