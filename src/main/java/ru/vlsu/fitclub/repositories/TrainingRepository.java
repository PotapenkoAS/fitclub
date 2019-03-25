package ru.vlsu.fitclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.Training;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Integer> {
}
