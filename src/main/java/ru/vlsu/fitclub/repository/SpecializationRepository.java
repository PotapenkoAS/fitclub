package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.entity.Specialization;

@Repository
public interface SpecializationRepository extends CrudRepository<Specialization,Integer> {
}
