package com.bvan.jc.chat2.employee.persistence.test;

import com.bvan.jc.chat2.employee.Entity;
import com.bvan.jc.chat2.employee.persistence.generic.GenericDao;

/**
 * @author bvanchuhov
 */
class Dog implements Entity<Long> {

    private final long id;
    private final String name;

    public Dog(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

