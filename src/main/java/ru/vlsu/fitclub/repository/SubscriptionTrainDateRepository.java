package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.SubscriptionTrainDate;

@Repository
public interface SubscriptionTrainDateRepository extends CrudRepository<SubscriptionTrainDate,Integer> {
}