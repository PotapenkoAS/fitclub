package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.compositeKeys.ActivityPackKey;
import ru.vlsu.fitclub.model.entity.ActivityPack;

@Repository
public interface ActivityPackRepository extends CrudRepository<ActivityPack, ActivityPackKey> {
}
