package ru.vlsu.fitclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    boolean existsByLogin(String login);

    boolean existsByLoginAndPassword(String login, String password);

    User findByLogin(String login);

    User findByUserId(int id);
}
