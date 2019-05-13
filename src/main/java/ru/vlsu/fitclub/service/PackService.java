package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.Pack;
import ru.vlsu.fitclub.repository.PackRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class PackService {

    private ActivityService activityService;
    private PackRepository pr;

    @Autowired
    public PackService(ActivityService activityService, PackRepository pr) {
        this.activityService = activityService;
        this.pr = pr;
    }

    public Collection<Pack> getPacksByActivityId(int activityId) {
        Activity activity = activityService.getActivityById(activityId);
        Collection<Pack> result = new ArrayList<>();
        activity.getActivityPacksByActivityId().forEach(i -> result.add(i.getPackByActivityPackId()));
        return result;
    }

    public Pack getPackByPackId(int packId) {
        return pr.findByPackId(packId);
    }
}
