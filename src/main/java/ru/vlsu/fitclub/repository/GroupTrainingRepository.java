package ru.vlsu.fitclub.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.entity.GroupTraining;

import java.sql.Timestamp;
import java.util.Collection;

@Repository
public interface GroupTrainingRepository extends CrudRepository<GroupTraining,Integer> {

    @Query(value = "select * from fitness_club.group_training;",nativeQuery = true)
    Collection<GroupTraining> findAll();

}
