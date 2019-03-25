package ru.vlsu.fitclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.Activity;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {
}
