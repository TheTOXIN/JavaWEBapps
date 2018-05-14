package com.toxin.springboot.dao;

import com.toxin.springboot.abstraction.AbstractDAO;
import com.toxin.springboot.entity.Item;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ItemDAO extends AbstractDAO<Item> {

    public List<Item> getAllItems() {
        String sql = "SELECT * FROM items";
        return (List<Item>)getManager().createNativeQuery(sql).getResultList();
    }

    @Override
    public Class<Item> getEntity() {
        return Item.class;
    }

}
