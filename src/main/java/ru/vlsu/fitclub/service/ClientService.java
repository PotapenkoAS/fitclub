package ru.vlsu.fitclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.Client;
import ru.vlsu.fitclub.repository.ClientRepository;

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


}
