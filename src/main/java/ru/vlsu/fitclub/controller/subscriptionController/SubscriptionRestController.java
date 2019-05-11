package ru.vlsu.fitclub.controller.subscriptionController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.restObject.ActivityPrice;
import ru.vlsu.fitclub.model.restObject.SelectArray;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.service.ActivityService;
import ru.vlsu.fitclub.service.TrainerService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SubscriptionRestController {

    private TrainerService trainerService;
    private ActivityService activityService;


    @Autowired
    public SubscriptionRestController(TrainerService trainerService, ActivityService activityService) {
        this.trainerService = trainerService;
        this.activityService = activityService;
    }

    @GetMapping("new_sub/trainerRefresh")
    public List<SelectArray> trainerRefresh(@RequestParam(name = "activityId", defaultValue = "0") int activityId) {
        List<Trainer> trainers = trainerService.getTrainersByActivityId(activityId);
        List<SelectArray> result = new ArrayList<>();
        for (Trainer entry : trainers) {
            result.add(new SelectArray(entry.getSurname() + " " + entry.getName(), String.valueOf(entry.getTrainerId())));
        }
        return result;
    }

    @GetMapping("new_sub/priceRefresh")
    public ActivityPrice priceRefresh(@RequestParam(name = "activityId", defaultValue = "0") int activityId) {
        Activity activity = activityService.getActivityById(activityId);
        return new ActivityPrice(activity.getPriceForYear()
                , activity.getPriceForMonth()
                , activity.getPriceForWeek()
                , activity.getPriceForTrain());
    }
}
