package com.bvan.jc.chat2.employee.persistence.generic;

/**
 * @author bvanchuhov
 */
public interface GenericDao<IdType, EntityType> {

    EntityType findById(IdType id);
    EntityType save(EntityType entity);
    EntityType remove(IdType id);
}
