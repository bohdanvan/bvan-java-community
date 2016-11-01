package com.bvan.jc.employee.runner;

import com.bvan.jc.employee.OtherEmployee;
import com.bvan.jc.employee.Position;
import com.bvan.jc.employee.util.PropertyUtils;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;

/**
 * @author bvanchuhov
 */
public class DbReaderRunner {

    public static void main(String[] args) {
        testDb(getDataSource());
    }

    private static DataSource getDataSource() {
        Properties properties = PropertyUtils.loadPropertyFromClasspath("db.properties");

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(properties.getProperty("db.url"));
        dataSource.setUser(properties.getProperty("db.user"));
        dataSource.setPassword(properties.getProperty("db.password"));

        return dataSource;
    }

    private static void testDb(DataSource dataSource) {
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM other_employee");

                while (resultSet.next()) {
                    OtherEmployee otherEmployee = prepareOtherEmployee(resultSet);

                    System.out.println(otherEmployee);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static OtherEmployee prepareOtherEmployee(ResultSet resultSet) throws SQLException {
        OtherEmployee otherEmployee = new OtherEmployee();
        otherEmployee.setId(resultSet.getInt("id"));
        otherEmployee.setName(resultSet.getString("name"));
        otherEmployee.setSurname(resultSet.getString("surname"));
        otherEmployee.setBirthDate(resultSet.getLong("birth_date"));
        otherEmployee.setHireDate(resultSet.getLong("hire_date"));
        otherEmployee.setPosition(Position.ofNumber(resultSet.getInt("position")));
        otherEmployee.setDescription(resultSet.getString("description"));
        return otherEmployee;
    }
}
