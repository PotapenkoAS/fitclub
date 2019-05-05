package ru.vlsu.fitclub.controller.activityController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.service.ActivityService;
import ru.vlsu.fitclub.service.TrainerService;

import java.util.ArrayList;
import java.util.Base64;

@Controller
public class ActivityController {

    private ActivityService activityService;
    private TrainerService trainerService;

    @Autowired
    public ActivityController(ActivityService activityService, TrainerService trainerService) {
        this.activityService = activityService;
        this.trainerService = trainerService;
    }

    @GetMapping("activity/{activityId}")
    public String getActivity(@PathVariable int activityId, Model model) {
        Activity activity = activityService.getActivityById(activityId);
        String image = Base64.getEncoder().encodeToString(activity.getImage());
        ArrayList<Trainer> trainers = trainerService.getTrainersByActivityId(activityId);
        model.addAttribute("activity", activity);
        model.addAttribute("image", image);
        model.addAttribute("trainers",trainers);
        return "activity/activity";
    }//todo на форме несколько фоток сделать доп таблицу с фотками для activity
}
