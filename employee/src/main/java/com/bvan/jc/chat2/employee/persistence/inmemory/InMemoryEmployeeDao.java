package com.bvan.jc.chat2.employee.persistence.inmemory;

import com.bvan.jc.chat2.employee.Employee;
import com.bvan.jc.chat2.employee.Manager;
import com.bvan.jc.chat2.employee.persistence.EmployeeDao;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bvanchuhov
 */
public class InMemoryEmployeeDao implements EmployeeDao {

    private Map<Long, Employee> idToEmployee = new HashMap<>();

    @Override
    public Employee findEmployee(long id) {
        return idToEmployee.get(id);
    }

    @Override
    public Manager findManager(long id) {
        Employee employee = idToEmployee.get(id);
        return (employee instanceof Manager) ? (Manager) employee : null;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        idToEmployee.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Manager saveManager(Manager manager) {
        saveEmployee(manager);
        return manager;
    }

    @Override
    public Employee removeEmployee(long id) {
        return removeEmployee(id);
    }

    @Override
    public Manager removeManager(long id) {
        Manager manager = findManager(id);
        if (manager != null) {
            removeEmployee(id);
            return manager;
        }
        return null;
    }
}
