package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Client;
import ru.vlsu.fitclub.model.entity.Pack;
import ru.vlsu.fitclub.model.entity.Subscription;
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
    @PersistenceContext
    private EntityManager em;


    @Autowired
    public ClientService(UserRepository ur) {
        this.ur = ur;
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

    public Collection<Subscription> getClientSubsByUserId(int userId) {
        return ur.findByUserId(userId).getClientByUserId().getSubscriptionsByClientId();
    }

    public List<Subscription> getClientSubsByPacksAndUserId(Collection<Pack> packs, int userId) {
        Client client = ur.findByUserId(userId).getClientByUserId();
        Query query = em.createNativeQuery("select * from Subscription " +
                "where pack_id in (:packs) " +
                "and client_id = :clientId ");
        query.setParameter("packs", packs);
        query.setParameter("clientId", client.getClientId());
        return (List<Subscription>) query.getResultList();
    }
}
