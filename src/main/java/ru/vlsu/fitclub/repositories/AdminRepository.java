package ru.vlsu.fitclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
}
