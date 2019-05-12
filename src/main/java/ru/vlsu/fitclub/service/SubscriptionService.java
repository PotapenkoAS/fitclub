package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.Subscription;
import ru.vlsu.fitclub.repository.SubscriptionRepository;

import java.util.Date;

@Service
public class SubscriptionService {

    private ActivityService activityService;
    private ClientService clientService;
    private UserService userService;
    private SubscriptionRepository sr;

    @Autowired
    public SubscriptionService(ActivityService activityService, ClientService clientService, UserService userService, SubscriptionRepository sr) {
        this.activityService = activityService;
        this.clientService = clientService;
        this.userService = userService;
        this.sr = sr;
    }

    public Subscription prepareNewSub(int activityId, int year, int months, int week, int count, boolean activate) {
        Activity activity = activityService.getActivityById(activityId);
        float price = activityService.getPrice(year, months, week, count, activity);
        Subscription sub = new Subscription();
        int clientId = clientService.getClientByUserId(userService.getCurrentUserId()).getClientId();
        sub.setActivityId(activityId);
        sub.setIsActive(activate);
        sub.setClientId(clientId);
        sub.setPrice(price);
        sub.setDuration(year + ":" + months + ":" + week + ":");
        if (activate) {
            Date date = new Date();
            sub.setDateFrom(new java.sql.Date(date.getTime()));
        }
        sub.setNumberOfTrains(count);
        return sub;
    }

    public void save(Subscription sub) {
        sr.save(sub);
    }
}
