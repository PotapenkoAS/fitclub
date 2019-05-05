package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
}
