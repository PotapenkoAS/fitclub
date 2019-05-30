package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Achievement;
import ru.vlsu.fitclub.model.entity.ClientAchieves;
import ru.vlsu.fitclub.repository.AchievementsRepository;
import ru.vlsu.fitclub.repository.ClientAchievesRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

@Service
public class AchievementService {

    private AchievementsRepository ar;
    private ClientAchievesRepository car;

    @Autowired
    public AchievementService(AchievementsRepository ar, ClientAchievesRepository car) {
        this.ar = ar;
        this.car = car;
    }


    public ArrayList<Achievement> getAll() {
        return ar.findAll();
    }

    public void saveProgress(int clientId, int achievementId, double value) {
        ClientAchieves ca = new ClientAchieves();
        ca.setClientId(clientId);
        ca.setAchievementId(achievementId);
        ca.setValue(value);
        ca.setDate(new Date(new GregorianCalendar().getTime().getTime()));
        Achievement ach = ca.getAchievementByAchievementId();
        if (ach.getValue() < ca.getValue()) {
            ca.setDone(0);
            int oldRank = Integer.valueOf(ach.getDescription().split(" ")[1]);
            Collection<Achievement> achievements = ach.getActivityByActivityId().getAchievementsByActivityId();
            for (Achievement entry : achievements) {
                if (Integer.valueOf(entry.getDescription().split(" ")[1]) - oldRank == 1) {
                    ClientAchieves newCa = new ClientAchieves();
                    newCa.setDone(0);
                    newCa.setValue(0);
                    newCa.setAchievementId(entry.getAchievementId());
                    newCa.setDate(new Date(new GregorianCalendar().getTime().getTime()));
                    newCa.setClientId(clientId);
                    car.save(newCa);
                }
            }
        } else {
            ca.setDone(1);
        }
        car.save(ca);
    }
}
