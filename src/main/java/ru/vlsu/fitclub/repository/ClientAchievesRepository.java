package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.entity.ClientAchieves;
import ru.vlsu.fitclub.model.compositeKey.ClientAcvievesKey;

@Repository
public interface ClientAchievesRepository extends CrudRepository<ClientAchieves, ClientAcvievesKey> {
}
