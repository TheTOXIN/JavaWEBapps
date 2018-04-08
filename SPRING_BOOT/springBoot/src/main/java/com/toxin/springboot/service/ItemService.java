package com.toxin.springboot.service;

import com.toxin.springboot.abstraction.AbstractService;
import com.toxin.springboot.dao.ItemDAO;
import com.toxin.springboot.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService extends AbstractService<Item> {

    @Autowired
    private ItemDAO itemDAO;

    public List<Item> getAllItems() {
        return itemDAO.getAllItems();
    }

    @Override
    public ItemDAO getAbstractDAO() {
        return this.itemDAO;
    }

}
