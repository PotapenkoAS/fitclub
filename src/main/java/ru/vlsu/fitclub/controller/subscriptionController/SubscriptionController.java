package ru.vlsu.fitclub.controller.subscriptionController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.Pack;
import ru.vlsu.fitclub.model.entity.Subscription;
import ru.vlsu.fitclub.service.*;

import java.util.Collection;
import java.util.List;

@Controller
public class SubscriptionController {

    private ActivityService activityService;
    private UserService userService;
    private ClientService clientService;
    private SubscriptionService subscriptionService;
    private PackService packService;

    @Autowired
    public SubscriptionController(ActivityService activityService, UserService userService, ClientService clientService, SubscriptionService subscriptionService, PackService packService) {
        this.activityService = activityService;
        this.userService = userService;
        this.clientService = clientService;
        this.subscriptionService = subscriptionService;
        this.packService = packService;
    }

    @GetMapping("new_sub")
    public String getNewSubWithActivity(@RequestParam(name = "activity_id") int activityId, Model model) {
        Collection<Pack> packs = packService.getPacksByActivityId(activityId);
        model.addAttribute("packs", packs);
        model.addAttribute("activityId", activityId);
        return "subscription/new_sub";
    }

    @PostMapping("new_sub")
    public String postNewSub(int packId, Integer year, Integer month, Integer week, Integer count, boolean activate) {
        Subscription sub = subscriptionService.prepareNewSub(packId
                , year == null ? 0 : year
                , month == null ? 0 : month
                , week == null ? 0 : week
                , count == null ? 0 : count
                , activate);
        subscriptionService.save(sub);
        return "subscription/success";
    }
}
