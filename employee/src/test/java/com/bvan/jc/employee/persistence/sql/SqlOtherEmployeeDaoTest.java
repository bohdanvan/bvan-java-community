package com.bvan.jc.employee.persistence.sql;

import com.bvan.jc.employee.OtherEmployee;
import static com.bvan.jc.employee.generator.EmployeeGenerator.randomOtherEmployee;
import com.bvan.jc.employee.persistence.OtherEmployeeDao;
import com.bvan.jc.employee.util.PropertyUtils;
import static com.google.common.base.Charsets.UTF_8;
import com.google.common.io.Resources;
import static com.google.common.io.Resources.getResource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author bvanchuhov
 */
public class SqlOtherEmployeeDaoTest {

    private DataSource dataSource;
    private OtherEmployeeDao otherEmployeeDao;

    @Before
    public void before() throws Exception {
        dataSource = getDataSource();
        createTables(dataSource);

        otherEmployeeDao = new SqlOtherEmployeeDao(dataSource);
    }

    @After
    public void after() throws Exception {
        dropTables();
    }

    @Test
    public void saveAndGetEmployee() {
        OtherEmployee employee = otherEmployeeDao.save(randomOtherEmployee());
        OtherEmployee employeeFromStorage = otherEmployeeDao.findById(employee.getId());
        assertThat(employeeFromStorage, is(employee));
    }

    @Test
    public void saveAndRemoveEmployee_checkNoEmployeesInStorage() {
        OtherEmployee employee = otherEmployeeDao.save(randomOtherEmployee());
        otherEmployeeDao.remove(employee.getId());
        OtherEmployee employeeFromStorage = otherEmployeeDao.findById(employee.getId());
        assertThat(employeeFromStorage, is(nullValue()));
    }

    @Test
    public void removeNonexistentEmployee() {
        OtherEmployee removedUser = otherEmployeeDao.remove(100L);
        assertThat(removedUser, is(nullValue()));
    }

    private void createTables(DataSource dataSource) {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(getCreationSql());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void dropTables() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE other_employee");
        }
    }

    private static DataSource getDataSource() {
        Properties dbProperties = PropertyUtils.loadPropertyFromClasspath("db.properties");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dbProperties.getProperty("db.driver"));
        dataSource.setUrl(dbProperties.getProperty("db.url"));
        dataSource.setUsername(dbProperties.getProperty("db.user"));
        dataSource.setPassword(dbProperties.getProperty("db.password"));
        return dataSource;
    }

    private static String getCreationSql() {
        try {
            return Resources.toString(getResource("sql/create-other-employee-table.sql"), UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
