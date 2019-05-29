package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.Pack;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.repository.ActivityRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Service
public class ActivityService {

    private ActivityRepository activityRepository;
    private PackService packService;
    private TrainerService trainerService;
    @PersistenceContext
    EntityManager em;

    @Autowired
    public ActivityService(ActivityRepository activityRepository, PackService packService, TrainerService trainerService) {
        this.activityRepository = activityRepository;
        this.packService = packService;
        this.trainerService = trainerService;
    }

    public Activity getById(int id) {
        return activityRepository.findByActivityId(id);
    }

    public ArrayList<Activity> getAll() {
        return activityRepository.findAll();
    }

    public float getPriceForPack(int year, int month, int week, int count, Pack pack) {
        float price = 0;
        ArrayList<Activity> activityList = new ArrayList<>(Collections.emptyList());
        pack.getActivityPacksByPackId().forEach(a -> activityList.add(a.getActivityByActivityId()));
        if (year == 0 && month == 0 && week == 0) {
            if (count == 0) {
                return price;
            } else {
                for (Activity activity : activityList) {
                    price += count * activity.getPriceForTrain();
                }
            }
        } else {
            for (Activity activity : activityList) {
                price += year * activity.getPriceForYear() + month * activity.getPriceForMonth()
                        + week * activity.getPriceForWeek();
            }
        }
        return price;
    }

    public Collection<Activity> getAllByPackId(int packId) {
        Pack pack = packService.getById(packId);
        Collection<Activity> result = new ArrayList<>();
        pack.getActivityPacksByPackId().forEach(i -> result.add((i.getActivityByActivityId())));
        return result;
    }

    public ArrayList<Activity> getAllByTrainerId(int trainerId) {
        Query query = em.createQuery("select a from Activity a " +
                "inner join ActivitySpecialization acts on acts.activityId=a.activityId " +
                "inner join TrainerSpecialization ts on ts.specializationId=acts.specializationId " +
                "where ts.trainerId=:trainerId")
                .setParameter("trainerId", trainerId);

        return (ArrayList<Activity>)query.getResultList();
    }
}
