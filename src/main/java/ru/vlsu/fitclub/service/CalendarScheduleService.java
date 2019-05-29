package ru.vlsu.fitclub.service;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.GroupTraining;
import ru.vlsu.fitclub.model.entity.Training;
import ru.vlsu.fitclub.model.restObject.CalendarSchedule;
import ru.vlsu.fitclub.model.restObject.CalendarScheduleItem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class CalendarScheduleService {

    private TrainingService trainingService;
    private GroupTrainingService groupTrainingService;

    @Autowired
    public CalendarScheduleService(TrainingService trainingService, GroupTrainingService groupTrainingService) {
        this.trainingService = trainingService;
        this.groupTrainingService = groupTrainingService;
    }

    public ArrayList<CalendarSchedule> getListCalendarScheduleByTrainerIdForMonth(int trainerId, int offset) {
        GregorianCalendar dateFrom = new GregorianCalendar();
        dateFrom.add(Calendar.MONTH, offset);
        dateFrom.set(Calendar.DAY_OF_MONTH, 1);
        GregorianCalendar dateTo = new GregorianCalendar();
        dateTo.add(Calendar.MONTH, offset);
        dateTo.set(Calendar.DAY_OF_MONTH, dateTo.getActualMaximum(Calendar.DAY_OF_MONTH));
        ArrayList<Training> trainings = trainingService.getAllByTrainerIdAndDate(trainerId, dateFrom.getTime(), dateTo.getTime());
        ArrayList<GroupTraining> groupTrainings = groupTrainingService.getAllByTrainerIdAndDate(trainerId, dateFrom.getTime(), dateTo.getTime());
        return mergeLists(trainings, groupTrainings, dateFrom);
    }

    private ArrayList<CalendarSchedule> mergeLists(ArrayList<Training> trainings, ArrayList<GroupTraining> groupTrainings, GregorianCalendar calendar) {
        GregorianCalendar curCal = (GregorianCalendar) calendar.clone();
        GregorianCalendar monthEnd = (GregorianCalendar) calendar.clone();
        monthEnd.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        curCal.add(Calendar.DAY_OF_MONTH, (curCal.get(Calendar.DAY_OF_WEEK) - 2) * -1);
        ArrayList<CalendarSchedule> result = new ArrayList<>();
        while (curCal.compareTo(monthEnd) < 0) {
            CalendarSchedule cs = new CalendarSchedule();
            cs.getDays().forEach((i) -> {
                i.getValue().setDate((GregorianCalendar) curCal.clone());
                curCal.set(Calendar.DAY_OF_MONTH, curCal.get(Calendar.DAY_OF_MONTH) + 1);
            });
            result.add(cs);
        }
        GregorianCalendar tmp = new GregorianCalendar();
        for (Training entry : trainings) {
            tmp.setTime(entry.getDate());
            int weekIndex = tmp.get(Calendar.WEEK_OF_MONTH) - 1;
            int dayOfWeek = getDayOfWeek(tmp.get(Calendar.DAY_OF_WEEK)) - 1;
            CalendarScheduleItem item = result.get(weekIndex).getDays().get(dayOfWeek).getValue();
            item.setTrainingId(entry.getTrainingId());
            item.setCount(item.getCount() + 1);
            item.setText(item.getText() + "\n" + entry.getTimeBegin() + " - " + entry.getTimeEnd() + ". " + entry.getActivityByActivityId().getName());
            result.get(weekIndex).setItem(dayOfWeek, item);

        }
        for (GroupTraining entry : groupTrainings) {
            tmp.setTime(entry.getDate());
            int weekIndex = tmp.get(Calendar.WEEK_OF_MONTH) - 1;
            int dayOfWeek = getDayOfWeek(tmp.get(Calendar.DAY_OF_WEEK)) - 1;
            CalendarScheduleItem item = result.get(weekIndex).getDays().get(dayOfWeek).getValue();
            item.setGroupId(entry.getGroupId());
            item.setCount(item.getCount() + 1);
            item.setText(item.getText() + "\n" + entry.getTimeBegin() + " - " + entry.getTimeEnd() + ". " + entry.getActivityByActivityId().getName());
            result.get(weekIndex).setItem(dayOfWeek, item);
        }
        return result;
    }

    private int getDayOfWeek(int day) {
        switch (day) {
            case 1:
                return 7;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            default:
                return 0;
        }
    }
}
