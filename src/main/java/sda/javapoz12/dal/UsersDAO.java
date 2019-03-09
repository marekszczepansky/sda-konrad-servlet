package sda.javapoz12.dal;

import sda.javapoz12.domain.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UsersDAO {
    private static UsersDAO ourInstance = new UsersDAO();
    private static Integer LAST_INDEX = 0;

    public static UsersDAO getInstance() {
        return ourInstance;
    }

    private UsersDAO() { }

    private Map<Integer, User> storage = new HashMap<>();

    public User save(User newUser){
        newUser.setId(++LAST_INDEX);
        return storage.put(
                newUser.getId(),  // klucz wyszukiwania
                newUser           // wartość przechowywana
        );
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
}
