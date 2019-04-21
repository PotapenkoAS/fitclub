package ru.vlsu.fitclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.Achievement;

@Repository
public interface AchievementsRepository extends CrudRepository<Achievement, Integer> {
}
