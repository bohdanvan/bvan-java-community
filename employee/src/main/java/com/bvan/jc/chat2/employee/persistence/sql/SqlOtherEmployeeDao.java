package com.bvan.jc.chat2.employee.persistence.sql;

import com.bvan.jc.chat2.employee.OtherEmployee;
import com.bvan.jc.chat2.employee.Position;
import com.bvan.jc.chat2.employee.persistence.EmployeePersistenceException;
import com.bvan.jc.chat2.employee.persistence.OtherEmployeeDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author bvanchuhov
 */
public class SqlOtherEmployeeDao implements OtherEmployeeDao {

    private final PreparedStatement psGetById;
    private final PreparedStatement psSave;
    private final PreparedStatement psRemove;

    public SqlOtherEmployeeDao(Connection connection) {
        try {
            this.psGetById = connection.prepareStatement("SELECT * FROM other_employee WHERE id = ?");
            this.psSave = connection.prepareStatement(
                    "INSERT INTO other_employee(name, surname, birth_date, hire_date, position, description) " +
                            "VALUES (?, ?, ?, ?, ?, ?)"
            );
            this.psRemove = connection.prepareStatement(
                    "DELETE FROM other_employee WHERE id = ?"
            );
        } catch (SQLException e) {
            throw new EmployeePersistenceException("Can't prepare statements", e);
        }
    }

    @Override
    public OtherEmployee findById(Long id) {
        try {
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
        try {
            psSave.setString(1, entity.getName());
            psSave.setString(2, entity.getSurname());
            psSave.setLong(3, entity.getBirthDate());
            psSave.setLong(4, entity.getHireDate());
            psSave.setInt(5, entity.getPosition().getNumber());
            psSave.setString(6, entity.getDescription());

            psSave.execute();

            // TODO: get generated id from db

            return entity;
        } catch (SQLException e) {
            throw new EmployeePersistenceException("Can't save other employee: " + entity, e);
        }
    }

    @Override
    public OtherEmployee remove(Long id) {
        try {
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
