package com.bvan.jc.chat2.employee.persistence.inmemory;

import com.bvan.jc.chat2.employee.OtherEmployee;
import com.bvan.jc.chat2.employee.persistence.OtherEmployeeDao;
import com.bvan.jc.chat2.employee.persistence.generic.InMemoryDao;

/**
 * @author bvanchuhov
 */
public class InMemoryOtherEmployeeDao
        extends InMemoryDao<Long, OtherEmployee> implements OtherEmployeeDao {
}
