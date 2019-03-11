package sda.javapoz12.dal;

import sda.javapoz12.domain.User;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class UsersDAOJpa implements UsersDAO {

    private static UsersDAO ourInstance = new UsersDAOJpa();
    private final EntityManagerFactory emf;

    public static UsersDAO getInstance() {
        return ourInstance;
    }

    public UsersDAOJpa() {
        // TODO: wybór bazy danych PU - H2, PUmysql - MySql
        emf = Persistence.createEntityManagerFactory("PUmysql");
        save(new User("Artur", "Boruc", 33, "artur@boruc"));
        save(new User("Szymon", "Paluch", 24, "szymon@paluch"));
    }


    private User executeTransaction(Function<EntityManager, User> c) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        User result = null;
        try {
            tx.begin();
            result = c.apply(em);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
            return result;
        }
    }

    @Override
    public User save(User newUser) {
        return executeTransaction(entityManager -> {
            entityManager.persist(newUser);
            return newUser;
        });
    }

    @Override
    public User getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public Collection<User> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("FROM User", User.class);
            List<User> users = query.getResultList();
            return users;

        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Integer id) {
        executeTransaction(entityManager -> {
            User user = entityManager.find(User.class, id);
            entityManager.remove(user);
            return null;
        });
    }

    @Override
    public User update(User user) {
        return executeTransaction(entityManager -> {
            entityManager.merge(user);
            return user;
        });
    }
}
