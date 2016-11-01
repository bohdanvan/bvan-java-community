package com.bvan.jc.employee.persistence.inmemory;

import com.bvan.jc.employee.OtherEmployee;
import com.bvan.jc.employee.persistence.OtherEmployeeDao;
import com.bvan.jc.employee.persistence.generic.InMemoryDao;

/**
 * @author bvanchuhov
 */
public class InMemoryOtherEmployeeDao
        extends InMemoryDao<Long, OtherEmployee> implements OtherEmployeeDao {
}
