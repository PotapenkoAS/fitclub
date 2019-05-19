package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Trainer;
import ru.vlsu.fitclub.repository.TrainerRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {

    private TrainerRepository trainerRepository;
    private EntityManager em;

    @Autowired
    public TrainerService(TrainerRepository trainerRepository, EntityManager em) {
        this.trainerRepository = trainerRepository;
        this.em = em;
    }

    public ArrayList<Trainer> getTrainersByActivityId(int activityId) {
        Query query = em.createQuery("select t from Trainer t " +
                "inner join TrainerSpecialization ts on ts.trainerId = t.trainerId " +
                "inner join ActivitySpecialization acts on acts.specializationId = ts.specializationId " +
                "where acts.activityId = :activityId")
                .setParameter("activityId", activityId);
        List queryResultList = query.getResultList();
        ArrayList<Trainer> result = new ArrayList<>();
        for (Object entry : queryResultList) {
            result.add((Trainer) entry);
        }
        return result;
    }

    public ArrayList<Trainer> getTrainerList() {
        return trainerRepository.findAll();
    }

    public Trainer getTrainerByUserId (int userId){
        return trainerRepository.findByUserId(userId);
    }
}
