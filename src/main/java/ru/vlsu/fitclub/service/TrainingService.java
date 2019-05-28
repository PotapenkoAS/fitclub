package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Training;
import ru.vlsu.fitclub.repository.TrainingRepository;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TrainingService {

    private TrainingRepository tr;

    @Autowired
    public TrainingService(TrainingRepository tr) {
        this.tr = tr;
    }

    public Training getById(int trainingId) {
        return tr.findByTrainingId(trainingId);
    }

    public ArrayList<Training> getAll() {
        return tr.findAll();
    }

    public ArrayList<Training> getAllByTrainerId(int trainerId) {
        return tr.findAllByTrainerId(trainerId);
    }

    public ArrayList<Training> getAllByTrainerIdAndDate(int trainerId, Date dateFrom, Date dateTo) {
        return tr.findAllByTrainerIdAndDateIsLessThanAndDateIsGreaterThanEqual(trainerId,dateTo,dateFrom);
    }
}
