package com.toxin.springboot.controller;

import com.toxin.springboot.abstraction.AbstractController;
import com.toxin.springboot.abstraction.AbstractService;
import com.toxin.springboot.entity.Item;
import com.toxin.springboot.entity.User;
import com.toxin.springboot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("items")
public class ItemController extends AbstractController<Item> {

    @Autowired
    private ItemService itemService;

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllUsers() {
        System.out.println("GET ALL USER");
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @Override
    public ItemService getAbstractService() {
        return this.itemService;
    }
}
