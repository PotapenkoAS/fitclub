package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.entity.Activity;
import ru.vlsu.fitclub.model.entity.Client;
import ru.vlsu.fitclub.model.entity.Subscription;

import java.util.Collection;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,Integer> {

}
