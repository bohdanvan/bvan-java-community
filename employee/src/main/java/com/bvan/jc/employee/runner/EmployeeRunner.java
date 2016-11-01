package com.bvan.jc.employee.runner;

import com.bvan.jc.employee.Employee;
import com.bvan.jc.employee.Manager;
import com.bvan.jc.employee.OtherEmployee;
import com.bvan.jc.employee.Position;
import com.bvan.jc.employee.persistence.inmemory.InMemoryEmployeeDao;
import com.bvan.jc.employee.persistence.inmemory.InMemoryOtherEmployeeDao;

import com.bvan.jc.employee.persistence.EmployeeDao;
import com.bvan.jc.employee.persistence.OtherEmployeeDao;
import com.bvan.jc.employee.util.DateUtils;

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
        vasya.setBirthDate(DateUtils.getTimestamp(1975, 3, 14));
        vasya.setHireDate(DateUtils.getTimestamp(2000, 1, 10));
        return vasya;
    }

    private static Manager createYura() {
        Manager yura = new Manager();
        yura.setName("Yura");
        yura.setSurname("Molchan");
        yura.setBirthDate(DateUtils.getTimestamp(1980, 6, 8));
        yura.setHireDate(DateUtils.getTimestamp(2002, 10, 11));
        return yura;
    }

    private static Employee createBohdan() {
        Employee bohdan = new Employee();
        bohdan.setName("Bohdan");
        bohdan.setSurname("Kutepov");
        bohdan.setBirthDate(DateUtils.getTimestamp(1978, 6, 1));
        bohdan.setHireDate(DateUtils.getTimestamp(2002, 10, 11));
        return bohdan;
    }

    private static OtherEmployee createSerhey() {
        OtherEmployee serhey = new OtherEmployee();
        serhey.setName("Serhey");
        serhey.setSurname("Serheev");
        serhey.setBirthDate(DateUtils.getTimestamp(1983, 6, 8));
        serhey.setHireDate(DateUtils.getTimestamp(2002, 10, 11));
        serhey.setPosition(Position.SECRETARY);
        serhey.setDescription("Does some work");
        return serhey;
    }
}
