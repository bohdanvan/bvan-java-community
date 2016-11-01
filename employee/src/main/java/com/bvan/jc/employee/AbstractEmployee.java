package com.bvan.jc.employee;

import com.bvan.jc.employee.util.IdGenerator;

/**
 * @author bvanchuhov
 */
public abstract class AbstractEmployee implements Entity<Long> {

    protected long id = IdGenerator.generateId();
    protected String name;
    protected String surname;
    protected long birthDate;
    protected long hireDate;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public long getHireDate() {
        return hireDate;
    }

    public void setHireDate(long hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "AbstractEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                '}';
    }
}
