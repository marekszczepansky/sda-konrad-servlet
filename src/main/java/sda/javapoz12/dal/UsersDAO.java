package sda.javapoz12.dal;

import sda.javapoz12.domain.User;

import java.util.Collection;

public interface UsersDAO {
    User save(User newUser);

    User getById(Integer id);

    Collection<User> getAll();

    void delete(Integer id);

    User update(User user);
}
