package com.bvan.jc.chat2.employee.persistence;

import com.bvan.jc.chat2.employee.Employee;
import com.bvan.jc.chat2.employee.Manager;

/**
 * @author bvanchuhov
 */
public interface EmployeeDao {

    Employee findEmployee(long id);
    Manager findManager(long id);

    Employee saveEmployee(Employee employee);
    Manager saveManager(Manager manager);

    Employee removeEmployee(long id);
    Manager removeManager(long id);
}
