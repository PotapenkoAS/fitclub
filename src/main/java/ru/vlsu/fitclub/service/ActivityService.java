package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.repository.ActivityRepository;

import java.util.ArrayList;

@Service
public class ActivityService {

    ActivityRepository activityRepository;

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

}
