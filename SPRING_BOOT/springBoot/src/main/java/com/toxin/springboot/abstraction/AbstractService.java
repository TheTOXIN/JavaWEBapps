package com.toxin.springboot.abstraction;

public abstract class AbstractService<Entity extends AbstractEntity> {

    public abstract AbstractDAO<Entity> getAbstractDAO();

    public Entity getEntityById(Long id) {
        return getAbstractDAO().getEntityById(id);
    }

    public void addEntity(Entity entity) {
        getAbstractDAO().addEntity(entity);
    }

    public void updateEntity(Entity entity) {
        getAbstractDAO().updateEntity(entity);
    }

    public void deleteEntity(Long id) {
        getAbstractDAO().deleteEntity(id);
    }

}
