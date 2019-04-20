package ru.vlsu.fitclub.service;

import org.springframework.stereotype.Service;
import ru.vlsu.fitclub.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class LabService {
    @PersistenceContext
    private EntityManager em;

    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    public List getUserAndClient() {
        Query query = em.createQuery("Select u,c from User u inner join Client c on c.userId = u.userId");
        return query.setMaxResults(10).getResultList();

    }

}
