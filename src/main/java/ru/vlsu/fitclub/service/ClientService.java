package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.Client;
import ru.vlsu.fitclub.repository.ClientRepository;

import java.util.ArrayList;
import java.util.Base64;

@Service
public class ClientService {

    private ClientRepository cr;

    @Autowired
    public ClientService(ClientRepository cr) {
        this.cr = cr;
    }

    public Client getClientByUserId(int id) {
        return cr.findClientByUserId(id);
    }

    public ArrayList<String> getClientAchievementsImages(Client client){
        ArrayList<byte[]> imageList = new ArrayList<>();
        client.getClientAchievesByClientId().forEach(i->imageList.add(i.getAchievementByAchievementId().getImage()));
        ArrayList<String> stringImageList= new ArrayList<>();
        for(byte [] img: imageList){
            stringImageList.add(Base64.getEncoder().encodeToString(img));
        }
        return stringImageList;
    }

}