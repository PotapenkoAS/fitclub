package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.TrainerSpecialization;

@Repository
public interface TrainerSpecializationRepository extends CrudRepository<TrainerSpecialization, Integer> {
}
