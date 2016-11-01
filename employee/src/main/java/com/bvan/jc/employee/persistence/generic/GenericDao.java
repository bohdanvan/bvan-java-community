package com.bvan.jc.employee.persistence.generic;

import com.bvan.jc.employee.Entity;

/**
 * @author bvanchuhov
 */
public interface GenericDao<IdType, EntityType extends Entity<IdType>> {

    EntityType findById(IdType id);
    EntityType save(EntityType entity);
    EntityType remove(IdType id);
}
