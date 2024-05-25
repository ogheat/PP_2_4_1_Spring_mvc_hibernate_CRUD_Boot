package com.example.SpringBootWeb.dao;

import com.example.SpringBootWeb.model.User;


import java.util.List;


public interface UserDao {
    List<User> getUsers();

    User getUserById(int id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}
