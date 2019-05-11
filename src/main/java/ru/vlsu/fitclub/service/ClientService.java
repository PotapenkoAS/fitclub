package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.entity.Client;
import ru.vlsu.fitclub.model.entity.Subscription;
import ru.vlsu.fitclub.repository.ClientRepository;
import ru.vlsu.fitclub.repository.UserRepository;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;

@Service
public class ClientService {

    private UserRepository ur;

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
}
