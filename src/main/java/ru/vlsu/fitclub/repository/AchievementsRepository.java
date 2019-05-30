package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.entity.Achievement;

import java.util.ArrayList;

@Repository
public interface AchievementsRepository extends CrudRepository<Achievement, Integer> {
    ArrayList<Achievement> findAll();
}
