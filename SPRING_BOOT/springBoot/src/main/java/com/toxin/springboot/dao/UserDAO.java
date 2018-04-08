package com.toxin.springboot.dao;

import com.toxin.springboot.abstraction.AbstractDAO;
import com.toxin.springboot.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserDAO extends AbstractDAO<User> {

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        return (List<User>)getManager().createNativeQuery(sql).getResultList();
    }

    @Override
    public void update(User entity, User old) {
        entity.setSurname(old.getSurname());
        entity.setName(old.getName());
        entity.setItems(old.getItems());
        entity.setBirthday(old.getBirthday());
        entity.setAvatar(old.getAvatar());
    }

    @Override
    public Class<User> getEntity() {
        return User.class;
    }

}
