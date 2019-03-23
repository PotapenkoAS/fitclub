package ru.vlsu.fitclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.Specialization;

@Repository
public interface SpecializationRepository extends CrudRepository<Specialization,Long> {
}
