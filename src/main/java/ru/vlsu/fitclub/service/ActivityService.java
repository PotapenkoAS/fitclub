package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.repository.ActivityRepository;

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


}
