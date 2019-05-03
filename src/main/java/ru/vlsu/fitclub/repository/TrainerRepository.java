package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.Trainer;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer,Integer> {
}
