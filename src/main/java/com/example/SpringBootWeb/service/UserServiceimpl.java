package com.example.SpringBootWeb.service;

import com.example.SpringBootWeb.dao.UserDao;
import com.example.SpringBootWeb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceimpl(UserDao userDao) {

        this.userDao = userDao;

    }


    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
