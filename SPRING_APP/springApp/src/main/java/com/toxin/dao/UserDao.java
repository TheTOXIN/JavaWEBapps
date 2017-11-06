package com.toxin.dao;

import com.toxin.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User getById(int id);

    void delete(int id);

    void save(User user);

    void update(User user);
}
