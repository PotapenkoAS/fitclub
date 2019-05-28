package ru.vlsu.fitclub.controller.trainingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.service.ActivityService;

import java.util.ArrayList;

@Controller
public class NewTraining {

    ActivityService activityService;

    @Autowired
    public NewTraining(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/new_train")
    public String getNewTrain(int trainerId) {
        //todo: get here all trainer activities, and trainer schedule. On this schedule user will chose free days. Schedule have to be in form of calendar: Monday, Tuesday, Wednesday, Thursday, Friday
        ArrayList<Activity> activityList = activityService.getAllByTrainerId(trainerId);

        return "training/new_train";
    }
}
