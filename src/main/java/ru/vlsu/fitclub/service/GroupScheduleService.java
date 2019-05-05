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

    public ArrayList<GroupSchedule> getGroupSchedule(Date dateBegin, Date dateEnd, Time timeBegin, Time timeEnd, int trainerId, int activityId) {
        StringBuilder queryBuilder = new StringBuilder("select gt,t,a from GroupTraining gt");
        queryBuilder.append(" inner join Trainer t on t.trainerId = gt.trainerId");
        queryBuilder.append(" inner join Activity a on a.activityId = gt.activityId");
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
        List queryResults = query.setMaxResults(50).getResultList();

        List<ResultObject> result = extractResult(queryResults);

        ArrayList<GroupSchedule> results = new ArrayList<>();
        for (ResultObject item : result) {
            results.add(new GroupSchedule(item.getGroupTraining().getDate()
                    , item.getGroupTraining().getTimeBegin()
                    , item.getGroupTraining().getTimeEnd()
                    , item.getTrainer().getSurname() + " " + item.getTrainer().getName()
                    , item.getTrainer().getTrainerId()
                    , item.getActivity().getName()
                    , item.getActivity().getActivityId()));
        }
        return results;
    }

    private List<ResultObject> extractResult(List list) {

        List<ResultObject> results = new ArrayList<>();

        if (list == null || list.size() == 0) {
            return results;
        }

        for (Object entry : list) {

            Object[] arr = (Object[]) entry;

            ResultObject resultObject = new ResultObject();
            resultObject.setGroupTraining((GroupTraining) arr[0]); //todo refactor to JPA mapping
            resultObject.setTrainer((Trainer) arr[1]);
            resultObject.setActivity((Activity) arr[2]);
            results.add(resultObject);
        }

        return results;
    }

    public ArrayList<Trainer> getTrainerList() {
        return trainerRepository.findAll();
    }

    public ArrayList<Activity> getActivityList() {
        return activityRepository.findAll();
    }
}

class ResultObject {
    private GroupTraining groupTraining;
    private Activity activity;
    private Trainer trainer;

    GroupTraining getGroupTraining() {
        return groupTraining;
    }

    void setGroupTraining(GroupTraining groupTraining) {
        this.groupTraining = groupTraining;
    }

    Activity getActivity() {
        return activity;
    }

    void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
