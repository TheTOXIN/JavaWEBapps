package com.toxin.springdatarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{name}")
    public User findByName(@PathVariable final String name) {
        return userRepository.findByName(name);
    }

    @PostMapping("/load")
    public User load(@PathVariable final User user) {
        userRepository.save(user);
        return userRepository.findByName(user.getName());
    }
}
