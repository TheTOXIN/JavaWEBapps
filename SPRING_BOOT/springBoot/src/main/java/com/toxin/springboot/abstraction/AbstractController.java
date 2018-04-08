package com.toxin.springboot.abstraction;

import com.toxin.springboot.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class AbstractController<Entity extends AbstractEntity> {

    public abstract AbstractService getAbstractService();

    @GetMapping("/{id}")
    public ResponseEntity<Entity> getUserById(@PathVariable Long id) {
        System.out.println("GET ENTITY");
        Entity entity = (Entity) getAbstractService().getEntityById(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addUsers(@RequestBody Entity entity) {
        System.out.println("ADD ENTITY");
        getAbstractService().addEntity(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateUsers(@RequestBody User user) {
        System.out.println("UPDATE USER");
        getAbstractService().updateEntity(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        System.out.println("DELETE USER");
        getAbstractService().deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
