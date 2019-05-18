package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.Pack;
import ru.vlsu.fitclub.repository.ActivityRepository;
import ru.vlsu.fitclub.repository.PackRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PackService {


    private PackRepository pr;
    private ActivityRepository ar;

    @Autowired
    public PackService(PackRepository pr) {
        this.pr = pr;
    }

    public Collection<Pack> getPacksByActivityId(int activityId) {
        Activity activity = ar.findByActivityId(activityId);
        Collection<Pack> result = new ArrayList<>();
        activity.getActivityPacksByActivityId().forEach(i -> result.add(i.getPackByActivityPackId()));
        return result;
    }

    public Pack getPackByPackId(int packId) {
        return pr.findByPackId(packId);
    }

    public List<Pack> getAll(){
        return pr.findAll();
    }
}
