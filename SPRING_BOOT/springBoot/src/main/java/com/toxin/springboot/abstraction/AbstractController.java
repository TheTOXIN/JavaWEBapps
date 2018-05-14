package com.toxin.springboot.abstraction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class AbstractController<Entity extends AbstractEntity> {

    public abstract AbstractService<Entity> getAbstractService();

    @GetMapping("/{id}")
    public ResponseEntity<Entity> getEntityById(@PathVariable Long id) {
        System.out.println("GET ENTITY");
        Entity entity = getAbstractService().getEntityById(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addEntities(@RequestBody Entity entity) {
        System.out.println("ADD ENTITY");
        getAbstractService().addEntity(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateEntity(@RequestBody Entity entity) {
        System.out.println("UPDATE ENTITY");
        getAbstractService().updateEntity(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
        System.out.println("DELETE ENTITY");
        getAbstractService().deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
