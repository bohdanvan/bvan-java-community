package com.bvan.jc.employee.persistence.sql;

import com.bvan.jc.employee.OtherEmployee;
import com.bvan.jc.employee.Position;
import com.bvan.jc.employee.persistence.EmployeePersistenceException;
import com.bvan.jc.employee.persistence.OtherEmployeeDao;
import java.sql.*;
import javax.sql.DataSource;

/**
 * @author bvanchuhov
 */
public class SqlOtherEmployeeDao implements OtherEmployeeDao {

    private static final String SQL_GET_BY_ID = "SELECT * FROM other_employee WHERE id = ?";
    private static final String SQL_SAVE = "INSERT INTO other_employee(name, surname, birth_date, hire_date, position, description) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM other_employee WHERE id = ?";

    private DataSource dataSource;

    public SqlOtherEmployeeDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public OtherEmployee findById(Long id) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement psGetById = connection.prepareStatement(SQL_GET_BY_ID);
            psGetById.setLong(1, id);

            try (ResultSet resultSet = psGetById.executeQuery()) {
                if (!resultSet.next()) {
                    return null;
                }

                return prepareOtherEmployee(resultSet);
            }
        } catch (SQLException e) {
            throw new EmployeePersistenceException("Can't find other employee by id " + id, e);
        }
    }

    @Override
    public OtherEmployee save(OtherEmployee entity) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement psSave = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS);
            psSave.setString(1, entity.getName());
            psSave.setString(2, entity.getSurname());
            psSave.setLong(3, entity.getBirthDate());
            psSave.setLong(4, entity.getHireDate());
            psSave.setInt(5, entity.getPosition().getNumber());
            psSave.setString(6, entity.getDescription());

            psSave.execute();

            entity.setId(getGeneratedId(psSave));

            return entity;
        } catch (SQLException e) {
            throw new EmployeePersistenceException("Can't save other employee: " + entity, e);
        }
    }

    /**
     * @throws EmployeePersistenceException
     * @throws SQLException
     */
    private long getGeneratedId(PreparedStatement psSave) throws SQLException {
        try (ResultSet generatedKeys = psSave.getGeneratedKeys()) {
            if (!generatedKeys.next()) {
                throw new EmployeePersistenceException("No id obtained");
            }
            return generatedKeys.getLong(1);
        }
    }

    @Override
    public OtherEmployee remove(Long id) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement psRemove = connection.prepareStatement(SQL_DELETE);

            OtherEmployee prevEmployee = findById(id);

            if (prevEmployee != null) {
                psRemove.setLong(1, id);
                psRemove.execute();
            }

            return prevEmployee;
        } catch (SQLException e) {
            throw new EmployeePersistenceException("Can't remove other employee with id " + id, e);
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
