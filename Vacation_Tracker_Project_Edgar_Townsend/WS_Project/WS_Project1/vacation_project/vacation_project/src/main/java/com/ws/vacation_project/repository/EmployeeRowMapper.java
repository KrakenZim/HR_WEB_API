package com.ws.vacation_project.repository;

import com.ws.vacation_project.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setStart(rs.getDate("start"));
        employee.setEnd(rs.getDate("end"));
        return employee;
    }
}
