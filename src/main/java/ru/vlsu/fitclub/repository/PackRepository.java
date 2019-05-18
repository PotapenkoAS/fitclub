package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.entity.Pack;

import java.util.List;

@Repository
public interface PackRepository extends CrudRepository<Pack, Integer> {
    Pack findByPackId(int id);
    List<Pack> findAll();
}