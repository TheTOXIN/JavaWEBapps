package com.toxin.springboot.service;

import com.toxin.springboot.abstraction.AbstractService;
import com.toxin.springboot.dao.UserDAO;
import com.toxin.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends AbstractService{

    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public UserDAO getAbstractDAO() {
        return userDAO;
    }

}
