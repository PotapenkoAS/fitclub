package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.*;
import ru.vlsu.fitclub.model.viewObject.AchievementImageAndTitle;
import ru.vlsu.fitclub.repository.ClientRepository;
import ru.vlsu.fitclub.repository.GroupClientsRepository;
import ru.vlsu.fitclub.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

@Service
public class ClientService {

    private UserRepository ur;
    private ClientRepository cr;
    private GroupClientsRepository gcr;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public ClientService(UserRepository ur, ClientRepository cr, GroupClientsRepository gcr) {
        this.ur = ur;
        this.cr = cr;
        this.gcr = gcr;
    }

    public Client getClientByUserId(int id) {
        return ur.findByUserId(id).getClientByUserId();
    }

    public ArrayList<String> getClientAchievementsImages(Client client) {
        ArrayList<byte[]> imageList = new ArrayList<>();
        client.getClientAchievesByClientId().forEach(i -> imageList.add(i.getAchievementByAchievementId().getImage()));
        ArrayList<String> stringImageList = new ArrayList<>();
        for (byte[] img : imageList) {
            stringImageList.add(Base64.getEncoder().encodeToString(img));
        }
        return stringImageList;
    }

    public ArrayList<AchievementImageAndTitle> getAchievementImagesAndTitleByClient(Client client) {
        ArrayList<Achievement> achievementList;
        ArrayList<AchievementImageAndTitle> result = new ArrayList<>();
        Query query = em.createQuery("select a from Achievement a " +
                "inner join ClientAchieves ca on ca.achievementId=a.achievementId " +
                "where ca.clientId=:clientId and " +
                "ca.done=1")
                .setParameter("clientId", client.getClientId());
        achievementList = (ArrayList<Achievement>) query.getResultList();
        for (Achievement entry : achievementList) {
            result.add(new AchievementImageAndTitle(Base64.getEncoder().encodeToString(entry.getImage()), entry.getDescription()));
        }
        return result;
    }


    public Collection<Subscription> getClientSubsByUserId(int userId) {
        return ur.findByUserId(userId).getClientByUserId().getSubscriptionsByClientId();
    }

    public void addClientToGroupTraining(int clientId, int groupId) {
        GroupClients groupClients = new GroupClients();
        groupClients.setClientId(clientId);
        groupClients.setGroupId(groupId);
        gcr.save(groupClients);
    }

    public List<Subscription> getClientSubsByPacksAndUserId(Collection<Pack> packs, int userId) {
        Client client = ur.findByUserId(userId).getClientByUserId();
        Query query = em.createNativeQuery("select * from subscription " +
                "where pack_id in (:packs) " +
                "and client_id = :clientId ");
        query.setParameter("packs", packs);
        query.setParameter("clientId", client.getClientId());
        return (List<Subscription>) query.getResultList();
    }

    public void save(Client client) {
        cr.save(client);
    }

    public ArrayList<AchievementImageAndTitle> getClientTargets(Client client) {
        ArrayList<Achievement> achievementList;
        ArrayList<AchievementImageAndTitle> result = new ArrayList<>();
        Query query = em.createQuery("select a from Achievement a " +
                "inner join ClientAchieves ca on ca.achievementId = a.achievementId " +
                "where ca.clientId=:clientId and ca.done=0 " +
                "group by a.activityId")
                .setParameter("clientId", client.getClientId());
        achievementList = (ArrayList<Achievement>) query.getResultList();
        for (Achievement entry : achievementList) {
            result.add(new AchievementImageAndTitle(Base64.getEncoder().encodeToString(entry.getImage()), entry.getDescription()));
        }
        return result;
    }
}
