package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.repository.ActivityRepository;

import java.util.ArrayList;

@Service
public class ActivityService {

    private ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Activity getActivityById(int id) {
        return activityRepository.findByActivityId(id);
    }

    public ArrayList<Activity> getActivityList() {
        return activityRepository.findAll();
    }

    public float getPrice(int year, int month, int week, int count, Activity activity) {
        float price;
        if (year == 0 && month == 0 && week == 0) {
            if (count == 0) {
                price = 0;
            } else {
                price = count * activity.getPriceForTrain();
            }
        } else {
            price = year * activity.getPriceForYear() + month * activity.getPriceForMonth()
                    + week * activity.getPriceForWeek();
        }
        return price;
    }

}
