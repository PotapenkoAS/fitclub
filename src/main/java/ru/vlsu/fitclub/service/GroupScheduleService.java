package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.GroupSchedule;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.GroupTraining;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.repository.ActivityRepository;
import ru.vlsu.fitclub.repository.TrainerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupScheduleService {

    @PersistenceContext
    private EntityManager em;


    private TrainerRepository trainerRepository;
    private ActivityRepository activityRepository;

    @Autowired
    public GroupScheduleService(TrainerRepository trainerRepository, ActivityRepository activityRepository) {
        this.trainerRepository = trainerRepository;
        this.activityRepository = activityRepository;
    }

    public List<GroupTraining> getGroupSchedule(Date dateBegin, Date dateEnd, Time timeBegin, Time timeEnd, int trainerId, int activityId) {
        StringBuilder queryBuilder = new StringBuilder("select gt from GroupTraining gt");
        queryBuilder.append(" where gt.date >= '").append(dateBegin.toString()).append("'")
                .append(" and gt.date <= '").append(dateEnd.toString()).append("'");
        if (trainerId != 0) {
            queryBuilder.append(" and gt.trainerId = ").append(trainerId);
        }
        if (activityId != 0) {
            queryBuilder.append(" and gt.activityId = ").append(activityId);
        }
        if (timeBegin != null) {
            queryBuilder.append(" and gt.timeBegin >= '").append(timeBegin.toString()).append("'");
        }
        if (timeEnd != null) {
            queryBuilder.append(" and gt.timeEnd <= '").append(timeEnd.toString()).append("'");
        }


        Query query = em.createQuery(queryBuilder.toString());

        return (List<GroupTraining>) query.setMaxResults(50).getResultList();
    }

    public ArrayList<Trainer> getTrainerList() {
        return trainerRepository.findAll();
    }

    public ArrayList<Activity> getActivityList() {
        return activityRepository.findAll();
    }
}

