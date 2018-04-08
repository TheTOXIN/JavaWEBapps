package com.toxin.springboot.controller;

import com.toxin.springboot.abstraction.AbstractController;
import com.toxin.springboot.entity.User;
import com.toxin.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController extends AbstractController<User> {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        System.out.println("GET ALL USER");
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @Override
    public UserService getAbstractService() {
        return this.userService;
    }

}
