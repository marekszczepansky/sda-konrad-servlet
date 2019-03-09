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

    private Map<String, User> storage = new HashMap<>();

    public User save(User newUser){
        return storage.put(
                newUser.getSurname(),  // klucz wyszukiwania
                newUser                // wartość przechowywana
        );
    }

    public User getByName(String surname) {
        return storage.get(surname);
    }

    public Collection<User> getAll(){
        return storage.values();
    }

    public void delete(String surname) {
        storage.remove(surname);
    }
}
