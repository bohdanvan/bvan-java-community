package com.bvan.jc.employee.persistence;

import com.bvan.jc.employee.OtherEmployee;
import com.bvan.jc.employee.persistence.generic.GenericDao;

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
