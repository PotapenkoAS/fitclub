package ru.vlsu.fitclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.GroupDate;

@Repository
public interface GroupDateRepository extends CrudRepository<GroupDate,Integer> {
}
