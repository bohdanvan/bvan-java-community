package com.bvan.jc.employee.persistence.test;

import com.bvan.jc.employee.Entity;

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

