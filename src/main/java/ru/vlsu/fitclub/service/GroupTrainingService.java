package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.GroupTraining;
import ru.vlsu.fitclub.repository.GroupTrainingRepository;

@Service
public class GroupTrainingService {

    GroupTrainingRepository gtr;

    @Autowired
    public GroupTrainingService(GroupTrainingRepository gtr) {
        this.gtr = gtr;
    }

    public GroupTraining getById(int groupId) {
        return gtr.findByGroupId(groupId);
    }
}
