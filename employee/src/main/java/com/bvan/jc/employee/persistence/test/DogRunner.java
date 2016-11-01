package com.bvan.jc.employee.persistence.test;

import com.bvan.jc.employee.persistence.generic.GenericDao;
import com.bvan.jc.employee.persistence.generic.InMemoryDao;

/**
 * @author bvanchuhov
 */
class DogRunner {

    public static void main(String[] args) {
        GenericDao<Long, Dog> dogDao = new InMemoryDao<>();
        fillStorage(dogDao);

        Dog dog = dogDao.findById(10L);
        System.out.println(dog);
    }

    private static void fillStorage(GenericDao<Long, Dog> dogDao) {
        dogDao.save(new Dog(0L, "Rex"));
        dogDao.save(new Dog(1L, "Barbos"));
    }
}

