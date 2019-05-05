package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.entity.Training;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Integer> {
}
