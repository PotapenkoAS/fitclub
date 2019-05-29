package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.fitclub.model.entity.Training;
import ru.vlsu.fitclub.repository.TrainingRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

@Service
public class TrainingService {

    private TrainingRepository tr;
    @PersistenceContext
    EntityManager em;

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
        return tr.findAllByTrainerIdAndDateIsLessThanAndDateIsGreaterThanEqual(trainerId, dateTo, dateFrom);
    }

    public void save(int clientId, int trainerId, int activityId, Date date, Time timeBegin, Time timeEnd) {
        Training training = prepareNewTraining(clientId, trainerId, activityId, date, timeBegin, timeEnd);
        tr.save(training);
    }

    @Transactional
    public void delete(int clientId, int trainerId, int activityId, Date date, Time timeBegin, Time timeEnd) {
        Query query = em.createQuery("delete from Training " +
                "where clientId= :clientId and activityId= :activityId " +
                "and date = :date and timeBegin=:timeBegin and timeEnd=:timeEnd " +
                "and trainerId=:trainerId")
                .setParameter("clientId",clientId)
                .setParameter("activityId",activityId)
                .setParameter("date",date)
                .setParameter("timeBegin",timeBegin)
                .setParameter("timeEnd",timeEnd)
                .setParameter("trainerId",trainerId);
        query.executeUpdate();
    }


    private Training prepareNewTraining(int clientId, int trainerId, int activityId, Date date, Time timeBegin, Time timeEnd) {
        Training training = new Training();
        training.setClientId(clientId);
        training.setTrainerId(trainerId);
        training.setActivityId(activityId);
        training.setDate(new java.sql.Date(date.getTime()));
        training.setTimeBegin(timeBegin);
        training.setTimeEnd(timeEnd);
        return training;
    }
}
