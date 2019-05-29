package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.entity.GroupTraining;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Repository
public interface GroupTrainingRepository extends CrudRepository<GroupTraining, Integer> {

    Collection<GroupTraining> findAll();

    GroupTraining findByGroupId(int groupId);

    ArrayList<GroupTraining> findAllByTrainerId(int id);

    ArrayList<GroupTraining> findAllByTrainerIdAndDateIsLessThanAndDateIsGreaterThanEqual(int trainerId, Date dateTo, Date dateFrom);
}
