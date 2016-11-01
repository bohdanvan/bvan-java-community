package com.bvan.jc.employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bvanchuhov
 */
public class Manager extends Employee {

    private List<Long> employeeIds = new ArrayList<>();

    public void addEmployeeId(long employeeId) {
        employeeIds.add(employeeId);
    }

    public List<Long> getEmployeeIds() {
        return employeeIds;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", employeeIds=" + employeeIds +
                '}';
    }
}
