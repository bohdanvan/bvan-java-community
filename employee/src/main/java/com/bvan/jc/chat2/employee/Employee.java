package com.bvan.jc.chat2.employee;

/**
 * @author bvanchuhov
 */
public class Employee extends AbstractEmployee {

    private Long managerId;

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", managerId=" + managerId +
                '}';
    }
}
