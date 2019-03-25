package ru.vlsu.fitclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.fitclub.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    boolean existsByLogin(String login);
    boolean existsByLoginAndPassword(String login,String password);
    User findByLogin(String login);
}
