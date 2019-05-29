package ru.vlsu.fitclub.controller.trainingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.service.ActivityService;

import java.util.ArrayList;

@Controller
public class NewTraining {

    private ActivityService activityService;

    @Autowired
    public NewTraining(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/new_train")
    public String getNewTrain(int trainerId, Model model) {
        ArrayList<Activity> activityList = activityService.getAllByTrainerId(trainerId);
        model.addAttribute("activityList", activityList);
        model.addAttribute("trainerId",trainerId);
        return "training/new_train";
    }
}
