package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Pack;
import ru.vlsu.fitclub.model.entity.Subscription;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.repository.SubscriptionRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class SubscriptionService {

    private ActivityService activityService;
    private ClientService clientService;
    private UserService userService;
    private PackService packService;
    private SubscriptionRepository sr;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public SubscriptionService(ActivityService activityService, ClientService clientService, UserService userService, PackService packService, SubscriptionRepository sr) {
        this.activityService = activityService;
        this.clientService = clientService;
        this.userService = userService;
        this.packService = packService;
        this.sr = sr;
    }

    public Subscription prepareNewSub(int packId, int year, int months, int week, int count, boolean activate) {
        Pack pack = packService.getById(packId);
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

    public List<Subscription> getAllByUserIdAndActivityId(int userId, int activityId) {
        int clientId = clientService.getClientByUserId(userId).getClientId();
        Query query = em.createQuery("select s from Subscription s " +
                "inner join Pack p on p.packId=s.packId " +
                "inner join ActivityPack ap on ap.activityPackId = p.packId " +
                "where ap.activityId=:activityId " +
                "and s.clientId=:clientId");
        query.setParameter("activityId", activityId);
        query.setParameter("clientId", clientId);
        return (List<Subscription>) query.getResultList();
    }

    public List<Subscription> getAllByTrainerId(int trainerId) {
        int userId = userService.getCurrentUserId();
        int clientId = clientService.getClientByUserId(userId).getClientId();
        Query query = em.createQuery("select s from Subscription s " +
                "inner join Pack p on p.packId=s.packId " +
                "inner join TrainerPack tp on tp.packId = p.packId " +
                "where tp.trainerId=:trainerId " +
                "and s.clientId=:clientId");
        query.setParameter("trainerId", trainerId);
        query.setParameter("clientId", clientId);
        return (List<Subscription>) query.getResultList();
    }
}
