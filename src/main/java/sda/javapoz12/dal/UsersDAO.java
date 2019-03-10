package sda.javapoz12.dal;

import sda.javapoz12.domain.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UsersDAO {
    private static Integer LAST_INDEX = 0;
    private static UsersDAO ourInstance = new UsersDAO();
    private Map<Integer, User> storage = new HashMap<>();

    public static UsersDAO getInstance() {
        return ourInstance;
    }

    private UsersDAO() {
        save(new User("Artur", "Boruc", 33, "artur@boruc"));
        save(new User("Szymon", "Paluch", 24, "szymon@paluch"));
    }

    public User save(User newUser){
        newUser.setId(++LAST_INDEX);
        return update(newUser);
    }

    public User getById(Integer id) {
        return storage.get(id);
    }

    public Collection<User> getAll(){
        return storage.values();
    }

    public void delete(Integer id) {
        storage.remove(id);
    }

    public User update(User user) {
        return storage.put(
                user.getId(),  // klucz wyszukiwania
                user           // wartość przechowywana
        );
    }
}
