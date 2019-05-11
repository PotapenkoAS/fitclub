package ru.vlsu.fitclub.controller.subscriptionController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.fitclub.model.SelectArray;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.service.TrainerService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SubscriptionRestController {

    private TrainerService trainerService;

    @Autowired
    public SubscriptionRestController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("new_sub/trainerRefresh")
    public List<SelectArray> trainerRefresh(@RequestParam(name = "activityId", defaultValue = "0") int activityId) {
        List<Trainer> trainers = trainerService.getTrainersByActivityId(activityId);
        List<SelectArray> selectArrayList = new ArrayList<>();
        for (Trainer entry : trainers) {
            selectArrayList.add(new SelectArray(entry.getSurname() + " " + entry.getName(), String.valueOf(entry.getTrainerId())));
        }
        return selectArrayList;
    }
}
