package com.bvan.jc.chat2.employee.persistence.generic;

import com.bvan.jc.chat2.employee.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bvanchuhov
 */
public class InMemoryDao<IdType, EntityType extends Entity<IdType>> implements GenericDao<IdType, EntityType> {

    private Map<IdType, EntityType> idToEntity = new HashMap<>();

    @Override
    public EntityType findById(IdType id) {
        return idToEntity.get(id);
    }

    @Override
    public EntityType save(EntityType entity) {
        idToEntity.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public EntityType remove(IdType id) {
        return idToEntity.remove(id);
    }
}
