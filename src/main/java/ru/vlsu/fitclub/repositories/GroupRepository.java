package ru.vlsu.fitclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.Group;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
}
