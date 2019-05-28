package ru.vlsu.fitclub.controller.subscriptionController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.model.restObject.ActivityPrice;
import ru.vlsu.fitclub.model.restObject.SelectArray;
import ru.vlsu.fitclub.service.ActivityService;
import ru.vlsu.fitclub.service.TrainerService;

import java.util.ArrayList;
import java.util.Collection;
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
    public ActivityPrice priceRefresh(@RequestParam(name = "packId", defaultValue = "0") int packId) {
        Collection<Activity> activityList = activityService.getAllByPackId(packId);
        ActivityPrice result = new ActivityPrice(0,0,0,0);
        for (Activity item : activityList) {
            result.plusPriceForYear(item.getPriceForYear());
            result.plusPriceForMonth(item.getPriceForMonth());
            result.plusPriceForWeek(item.getPriceForWeek());
            result.plusPriceForTrain(item.getPriceForTrain());
        }
        return result;
    }

}
