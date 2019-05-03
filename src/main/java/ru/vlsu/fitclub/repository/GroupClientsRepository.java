package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.GroupClients;

@Repository
public interface GroupClientsRepository extends CrudRepository<GroupClients,Integer> {
}
