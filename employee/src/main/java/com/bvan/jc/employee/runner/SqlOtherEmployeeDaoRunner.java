package com.bvan.jc.employee.runner;

import com.bvan.jc.employee.OtherEmployee;
import com.bvan.jc.employee.Position;
import com.bvan.jc.employee.generator.EmployeeGenerator;
import com.bvan.jc.employee.persistence.OtherEmployeeDao;
import com.bvan.jc.employee.persistence.sql.SqlOtherEmployeeDao;
import com.bvan.jc.employee.util.DateUtils;
import com.bvan.jc.employee.util.PropertyUtils;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.Properties;
import javax.sql.DataSource;

/**
 * @author bvanchuhov
 */
public class SqlOtherEmployeeDaoRunner {

    public static void main(String[] args) {
        DataSource dataSource = getDataSource();
        OtherEmployeeDao otherEmployeeDao = new SqlOtherEmployeeDao(dataSource);

        for (int i = 0; i < 100_000; i++) {
            otherEmployeeDao.save(EmployeeGenerator.randomOtherEmployee());
        }
    }

    private static DataSource getDataSource() {
        Properties properties = PropertyUtils.loadPropertyFromClasspath("db.properties");

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(properties.getProperty("db.url"));
        dataSource.setUser(properties.getProperty("db.user"));
        dataSource.setPassword(properties.getProperty("db.password"));

        return dataSource;
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
