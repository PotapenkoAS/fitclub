package ru.vlsu.fitclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
}
