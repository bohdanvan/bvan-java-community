package com.bvan.jc.chat2.employee.persistence;

/**
 * @author bvanchuhov
 */
public class EmployeePersistenceException extends RuntimeException {

    public EmployeePersistenceException(String message) {
        super(message);
    }

    public EmployeePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
