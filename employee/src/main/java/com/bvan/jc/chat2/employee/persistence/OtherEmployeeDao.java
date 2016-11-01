package com.bvan.jc.chat2.employee.persistence;

import com.bvan.jc.chat2.employee.OtherEmployee;
import com.bvan.jc.chat2.employee.persistence.generic.GenericDao;

/**
 * @author bvanchuhov
 */
public interface OtherEmployeeDao extends GenericDao<Long, OtherEmployee> {

    /**
     * @throws EmployeePersistenceException
     */
    OtherEmployee findById(Long id);

    /**
     * @throws EmployeePersistenceException
     */
    OtherEmployee save(OtherEmployee entity);

    /**
     * @throws EmployeePersistenceException
     */
    OtherEmployee remove(Long id);
}
