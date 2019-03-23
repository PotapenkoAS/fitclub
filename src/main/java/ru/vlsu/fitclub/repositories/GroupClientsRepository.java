package ru.vlsu.fitclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.GroupClients;

@Repository
public interface GroupClientsRepository extends CrudRepository<GroupClients,Long> {
}
