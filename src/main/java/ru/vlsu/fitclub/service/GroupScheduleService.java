package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Client;
import ru.vlsu.fitclub.model.entity.GroupTraining;

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

    private UserService userService;
    private ClientService clientService;

    @Autowired
    public GroupScheduleService(UserService userService, ClientService clientService) {
        this.userService = userService;
        this.clientService = clientService;
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

    public void setIsRecordedForAll(List<GroupTraining> listGroupTraining) {
        int userId = userService.getCurrentUserId();
        if (userId == 0) {
            return;
        }
        Client client = clientService.getClientByUserId(userId);
        ArrayList<Integer> groupIdList = new ArrayList<>();
        client.getGroupClientsByClientId().forEach(i -> groupIdList.add(i.getGroupId()));
        for (GroupTraining item : listGroupTraining) {
            if (groupIdList.contains(item.getGroupId())) {
                item.setRecorded(true);
            }
        }
    }


}

