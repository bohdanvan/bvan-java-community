package com.bvan.jc.chat2.employee.persistence.generic;

import com.bvan.jc.chat2.employee.Entity;

/**
 * @author bvanchuhov
 */
public interface GenericDao<IdType, EntityType extends Entity<IdType>> {

    EntityType findById(IdType id);
    EntityType save(EntityType entity);
    EntityType remove(IdType id);
}
