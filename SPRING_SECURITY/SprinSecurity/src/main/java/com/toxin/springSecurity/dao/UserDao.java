package com.toxin.springSecurity.dao;

import com.toxin.springSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
