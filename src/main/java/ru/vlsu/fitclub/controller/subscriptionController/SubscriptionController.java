package ru.vlsu.fitclub.controller.subscriptionController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vlsu.fitclub.model.CustomUserDetails;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.Subscription;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.service.ActivityService;
import ru.vlsu.fitclub.service.ClientService;
import ru.vlsu.fitclub.service.TrainerService;
import ru.vlsu.fitclub.service.UserService;

import java.util.Collection;
import java.util.List;

@Controller
public class SubscriptionController {

    private ActivityService activityService;
    private TrainerService trainerService;
    private UserService userService;
    private ClientService clientService;

    @Autowired
    public SubscriptionController(ActivityService activityService, TrainerService trainerService, UserService userService, ClientService clientService) {
        this.activityService = activityService;
        this.trainerService = trainerService;
        this.userService = userService;
        this.clientService = clientService;
    }

    @GetMapping("new_sub")
    public String getNewSubWithActivity(@RequestParam(name = "activityId", defaultValue = "0") int activityId, Model model) {
        int userId = userService.getCurrentUserId();
        List<Subscription> subList = clientService.getClientSubsByActivityAndUserId(activityId, userId);
        if (subList.isEmpty()) {
            Collection<Activity> activityList = activityService.getActivityList();
            Collection<Trainer> trainerList = trainerService.getTrainersByActivityId(activityId);
            model.addAttribute("trainerList", trainerList);
            model.addAttribute("activityId", activityId);
            model.addAttribute("activityList", activityList);
            return "subscription/new_sub";
        } else {
            return "redirect:/subs?activityId=" + activityId; //todo validate inputs fuck, i dont want to do that shiet, just kill me plz
        }
    }

    @PostMapping("new_sub")
    public String postNewSub(int activityId, int year, int months, int week, int count) {
        Activity activity = activityService.getActivityById(activityId);

        return "";
    }
}
