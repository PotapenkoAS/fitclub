package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.GroupTraining;
import ru.vlsu.fitclub.model.entity.Training;
import ru.vlsu.fitclub.model.restObject.CalendarSchedule;

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

    public ArrayList<CalendarSchedule> getListCalendarScheduleByTrainerIdFormMonth(int trainerId, int offset) {
        GregorianCalendar dateWithOffset = new GregorianCalendar();
        dateWithOffset.add(Calendar.MONTH,offset);
        return null;
    }
}
