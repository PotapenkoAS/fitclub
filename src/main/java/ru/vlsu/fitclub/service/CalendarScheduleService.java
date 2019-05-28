package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.GroupTraining;
import ru.vlsu.fitclub.model.entity.Training;
import ru.vlsu.fitclub.model.restObject.CalendarSchedule;

import java.util.ArrayList;

@Service
public class CalendarScheduleService {

    private TrainingService trainingService;
    private GroupTrainingService groupTrainingService;

    @Autowired
    public CalendarScheduleService(TrainingService trainingService, GroupTrainingService groupTrainingService) {
        this.trainingService = trainingService;
        this.groupTrainingService = groupTrainingService;
    }

    public ArrayList<CalendarSchedule> getListCalendarScheduleByTrainerId(int trainerId) {
        ArrayList<Training> trainings = trainingService.getAllByTrainerId(trainerId);
        ArrayList<GroupTraining> groupTrainings = groupTrainingService.getAllByTrainerId(trainerId);
    }
}
