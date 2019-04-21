package ru.vlsu.fitclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.Subscription;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,Integer> {
}
