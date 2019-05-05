package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.entity.Activity;

import java.util.ArrayList;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {
    ArrayList<Activity> findAll();
    Activity findByActivityId(int id);
}
