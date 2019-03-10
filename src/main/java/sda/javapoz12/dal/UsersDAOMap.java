package sda.javapoz12.dal;

import sda.javapoz12.domain.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UsersDAOMap implements UsersDAO {
    private static Integer LAST_INDEX = 0;
    private static UsersDAO ourInstance = new UsersDAOMap();
    private Map<Integer, User> storage = new HashMap<>();

    public static UsersDAO getInstance() {
        return ourInstance;
    }

    private UsersDAOMap() {
        save(new User("Artur", "Boruc", 33, "artur@boruc"));
        save(new User("Szymon", "Paluch", 24, "szymon@paluch"));
    }

    @Override
    public User save(User newUser){
        newUser.setId(++LAST_INDEX);
        return update(newUser);
    }

    @Override
    public User getById(Integer id) {
        return storage.get(id);
    }

    @Override
    public Collection<User> getAll(){
        return storage.values();
    }

    @Override
    public void delete(Integer id) {
        storage.remove(id);
    }

    @Override
    public User update(User user) {
        return storage.put(
                user.getId(),  // klucz wyszukiwania
                user           // wartość przechowywana
        );
    }
}
