package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.entity.Training;

import java.util.ArrayList;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Integer> {
    Training findByTrainingId(int id);

    ArrayList<Training> findAll();

    ArrayList<Training> findAllByTrainerId(int id);
}
