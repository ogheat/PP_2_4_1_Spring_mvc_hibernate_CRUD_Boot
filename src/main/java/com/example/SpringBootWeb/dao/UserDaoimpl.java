package com.example.SpringBootWeb.dao;

import com.example.SpringBootWeb.model.User;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;



import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoimpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
