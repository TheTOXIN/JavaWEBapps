package com.toxin.springSecurity.service;

import com.toxin.springSecurity.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
