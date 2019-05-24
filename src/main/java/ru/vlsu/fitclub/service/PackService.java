package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.Pack;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.repository.ActivityRepository;
import ru.vlsu.fitclub.repository.PackRepository;
import ru.vlsu.fitclub.repository.TrainerRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PackService {

    private PackRepository pr;
    private ActivityRepository ar;
    private TrainerRepository tr;

    @Autowired
    public PackService(PackRepository pr, ActivityRepository ar, TrainerRepository tr) {
        this.pr = pr;
        this.ar = ar;
        this.tr = tr;
    }

    public ArrayList<Pack> getPacksByActivityId(int activityId) {
        Activity activity = ar.findByActivityId(activityId);
        ArrayList<Pack> result = new ArrayList<>();
        activity.getActivityPacksByActivityId().forEach(i -> result.add(i.getPackByActivityPackId()));
        return result;
    }

    public ArrayList<Pack> getPacksByTrainerId(int trainerId) {
        Trainer trainer = tr.findByTrainerId(trainerId);
        ArrayList<Pack> result = new ArrayList<>();
        trainer.getTrainerPacksByTrainerId().forEach(i -> result.add(i.getPackByPackId()));
        return result;
    }

    public Pack getById(int packId) {
        return pr.findByPackId(packId);
    }

    public List<Pack> getAll() {
        return pr.findAll();
    }
}
