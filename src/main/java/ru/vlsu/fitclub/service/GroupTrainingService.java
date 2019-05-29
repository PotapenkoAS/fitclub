package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.GroupTraining;
import ru.vlsu.fitclub.repository.GroupTrainingRepository;

import java.util.ArrayList;
import java.util.Date;

@Service
public class GroupTrainingService {

    private GroupTrainingRepository gtr;

    @Autowired
    public GroupTrainingService(GroupTrainingRepository gtr) {
        this.gtr = gtr;
    }

    public GroupTraining getById(int groupId) {
        return gtr.findByGroupId(groupId);
    }

    public ArrayList<GroupTraining> getAllByTrainerId(int trainerId) {
        return gtr.findAllByTrainerId(trainerId);
    }

    public ArrayList<GroupTraining> getAllByTrainerIdAndDate(int trainerId, Date dateFrom, Date dateTo) {
        return gtr.findAllByTrainerIdAndDateIsLessThanAndDateIsGreaterThanEqual(trainerId, dateTo, dateFrom);
    }

}
