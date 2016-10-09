package com.bvan.jc.chat2.employee.runner;

import com.bvan.jc.chat2.employee.Employee;
import com.bvan.jc.chat2.employee.Manager;
import com.bvan.jc.chat2.employee.OtherEmployee;
import com.bvan.jc.chat2.employee.Position;
import com.bvan.jc.chat2.employee.persistence.*;
import com.bvan.jc.chat2.employee.persistence.inmemory.InMemoryEmployeeDao;
import com.bvan.jc.chat2.employee.persistence.inmemory.InMemoryOtherEmployeeDao;

import static com.bvan.jc.chat2.employee.util.DateUtils.getTimestamp;

/**
 * @author bvanchuhov
 */
public class EmployeeRunner {

    private static final EmployeeDao employeeDao = new InMemoryEmployeeDao();
    private static final OtherEmployeeDao otherEmployeeDao = new InMemoryOtherEmployeeDao();

    private static Manager vasya;
    private static Manager yura;
    private static Employee bohdan;
    private static OtherEmployee serhey;

    public static void main(String[] args) {
        initEmployees();
        saveEmployees();

        printEmployees();

        Manager vasyaManager = findManagerOf(vasya);
        System.out.println("vasyaManager = " + vasyaManager);

        Manager yuraManager = findManagerOf(yura);
        System.out.println("yuraManager = " + yuraManager);

        Manager bohdanManager = findManagerOf(bohdan);
        System.out.println("bohdanManager = " + bohdanManager);
    }

    private static Manager findManagerOf(Employee bohdan) {
        return employeeDao.findManager(bohdan.getManagerId());
    }

    private static void initEmployees() {
        vasya = createVasya();
        yura = createYura();
        bohdan = createBohdan();
        serhey = createSerhey();

        vasya.addEmployeeId(yura.getId());
        yura.setManagerId(vasya.getId());

        yura.addEmployeeId(bohdan.getId());
        bohdan.setManagerId(yura.getId());
    }

    private static void saveEmployees() {
        employeeDao.saveManager(vasya);
        employeeDao.saveManager(yura);
        employeeDao.saveEmployee(bohdan);

        otherEmployeeDao.save(serhey);
    }

    private static void printEmployees() {
        System.out.println("vasya = " + vasya);
        System.out.println("yura = " + yura);
        System.out.println("bohdan = " + bohdan);
        System.out.println("serhey = " + serhey);
        System.out.println();
    }

    private static Manager createVasya() {
        Manager vasya = new Manager();
        vasya.setName("Vasya");
        vasya.setSurname("Pupkin");
        vasya.setPatronymic("Serheevich");
        vasya.setBirthDate(getTimestamp(1975, 3, 14));
        vasya.setHireDate(getTimestamp(2000, 1, 10));
        return vasya;
    }

    private static Manager createYura() {
        Manager yura = new Manager();
        yura.setName("Yura");
        yura.setSurname("Molchan");
        yura.setPatronymic("Serheevich");
        yura.setBirthDate(getTimestamp(1980, 6, 8));
        yura.setHireDate(getTimestamp(2002, 10, 11));
        return yura;
    }

    private static Employee createBohdan() {
        Employee bohdan = new Employee();
        bohdan.setName("Bohdan");
        bohdan.setSurname("Kutepov");
        bohdan.setPatronymic("Serheevich");
        bohdan.setBirthDate(getTimestamp(1978, 6, 1));
        bohdan.setHireDate(getTimestamp(2002, 10, 11));
        return bohdan;
    }

    private static OtherEmployee createSerhey() {
        OtherEmployee serhey = new OtherEmployee();
        serhey.setName("Serhey");
        serhey.setSurname("Serheev");
        serhey.setPatronymic("Serheevich");
        serhey.setBirthDate(getTimestamp(1983, 6, 8));
        serhey.setHireDate(getTimestamp(2002, 10, 11));
        serhey.setPosition(Position.SECRETARY);
        serhey.setDescription("Does some work");
        return serhey;
    }
}
