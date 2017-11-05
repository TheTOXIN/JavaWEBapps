package com.toxin.dao;

import com.toxin.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
