package ru.vlsu.fitclub.controller.subscriptionController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vlsu.fitclub.model.CustomUserDetails;
import ru.vlsu.fitclub.model.SelectArray;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.Subscription;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.service.ActivityService;
import ru.vlsu.fitclub.service.ClientService;
import ru.vlsu.fitclub.service.TrainerService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class SubscriptionController {

    private ClientService clientService;
    private ActivityService activityService;
    private TrainerService trainerService;


    @Autowired
    public SubscriptionController(ClientService clientService, ActivityService activityService, TrainerService trainerService) {
        this.clientService = clientService;
        this.activityService = activityService;
        this.trainerService = trainerService;
    }

    @GetMapping("new_sub")
    public String getNewSubWithActivity(@RequestParam(name = "activityId", defaultValue = "0") int activityId, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = ((CustomUserDetails) principal).getUserId();
        Collection<Activity> activityList = activityService.getActivityList();
        Collection<Subscription> subList = clientService.getClientSubsByUserId(userId);
        Collection<Trainer> trainerList = trainerService.getTrainerList();
        model.addAttribute("trainerList", trainerList);
        model.addAttribute("activityId", activityId);
        model.addAttribute("activityList", activityList);
        return "subscription/new_sub";
    }



    @PostMapping("new_sub")
    public String postNewSub() {
        return null;
    }
}
