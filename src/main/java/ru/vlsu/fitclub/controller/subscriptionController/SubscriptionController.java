package ru.vlsu.fitclub.controller.subscriptionController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.Subscription;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.service.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class SubscriptionController {

    private ActivityService activityService;
    private TrainerService trainerService;
    private UserService userService;
    private ClientService clientService;
    private SubscriptionService subscriptionService;


    @Autowired
    public SubscriptionController(ActivityService activityService, TrainerService trainerService, UserService userService, ClientService clientService, SubscriptionService subscriptionService) {
        this.activityService = activityService;
        this.trainerService = trainerService;
        this.userService = userService;
        this.clientService = clientService;
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("new_sub")
    public String getNewSubWithActivity(@RequestParam(name = "activity_id") int activityId, Model model) {
        int userId = userService.getCurrentUserId();
        List<Subscription> subList = new ArrayList<>();
        if (activityId > 0) {
            subList = clientService.getClientSubsByActivityAndUserId(activityId, userId);
        }else{
            model.addAttribute("error","Набор не выбран с какого то XYZ");
        }
        if (subList.isEmpty()) {
            Collection<Activity> activityList = activityService.getActivityList();
            Collection<Trainer> trainerList = trainerService.getTrainersByActivityId(activityId);
            model.addAttribute("activityId", activityId);
            model.addAttribute("activityList", activityList);
            return "subscription/new_sub";
        } else {
            return "redirect:/subs" + activityId; //todo validate inputs fuck, i dont want to do that shiet, just kill me plz
        }
    }

    @PostMapping("new_sub")
    public String postNewSub(int activityId, Integer year, Integer month, Integer week, Integer count, boolean activate) {
        Subscription sub = subscriptionService.prepareNewSub(activityId
                , year == null ? 0 : year
                , month == null ? 0 : month
                , week == null ? 0 : week
                , count == null ? 0 : count
                , activate);
        subscriptionService.save(sub);
        return "subscription/success";
    }
}
