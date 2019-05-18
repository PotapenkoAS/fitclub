package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Pack;
import ru.vlsu.fitclub.model.entity.Subscription;
import ru.vlsu.fitclub.repository.SubscriptionRepository;

import java.util.Date;

@Service
public class SubscriptionService {

    private ActivityService activityService;
    private ClientService clientService;
    private UserService userService;
    private PackService packService;
    private SubscriptionRepository sr;

    @Autowired
    public SubscriptionService(ActivityService activityService, ClientService clientService, UserService userService, PackService packService, SubscriptionRepository sr) {
        this.activityService = activityService;
        this.clientService = clientService;
        this.userService = userService;
        this.packService = packService;
        this.sr = sr;
    }

    public Subscription prepareNewSub(int packId, int year, int months, int week, int count, boolean activate) {
        Pack pack = packService.getPackByPackId(packId);
        float price = activityService.getPriceForPack(year, months, week, count, pack);
        Subscription sub = new Subscription();
        int clientId = clientService.getClientByUserId(userService.getCurrentUserId()).getClientId();
        sub.setPackId(packId);
        sub.setClientId(clientId);
        sub.setPrice(price);
        sub.setDuration(year + ":" + months + ":" + week);
        sub.setIsActive(activate);
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
