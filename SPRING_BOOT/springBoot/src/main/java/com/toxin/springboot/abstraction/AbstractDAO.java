package com.toxin.springboot.abstraction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public abstract class AbstractDAO<Entity extends AbstractEntity> {

    @PersistenceContext
    private EntityManager manager;

    public abstract Class<Entity> getEntity();

    public Entity getEntityById(Long id) {
        return manager.find(getEntity(), id);
    }

    public void addEntity(Entity entity) {
        manager.persist(entity);
    }

    public void updateEntity(Entity entity){
        manager.merge(entity);
    }

    public void deleteEntity(Long id) {
        manager.remove(getEntityById(id));
    }

    protected EntityManager getManager() {
        return manager;
    }

}
