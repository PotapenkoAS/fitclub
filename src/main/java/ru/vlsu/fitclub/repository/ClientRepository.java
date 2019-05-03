package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
}
