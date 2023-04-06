package com.ws.vacation_project.repository;

import com.ws.vacation_project.exception.DatabaseException;
import com.ws.vacation_project.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee saveEmployee(Employee employee){

        try{
            jdbcTemplate.update("Insert into employee (name, start, end) values (?,?,?)",
                    employee.getName(), employee.getStart(), employee.getEnd());
            //return the employee
            System.out.println("employee = " + employee);

            int id = jdbcTemplate.queryForObject(
                    "select max(id) from employee", Integer.class);
            employee.setId(id);
        }catch (Exception exc){
            throw new DatabaseException("an exception happened in saveEmployee ");
        }
            return employee;
    }

    public List<Employee> getAllEmployees(){

            return jdbcTemplate.query("SELECT id, name, start, end from employee",
                    (rs, rowNum) -> new Employee(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDate("start"),
                            rs.getDate("end")));
    }

    public Employee getEmployeeById(int id) {
        try {
            String sql = "SELECT * FROM employee WHERE ID = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());

        }catch (Exception exc){
            throw new DatabaseException("an exception happened in getEmployeeById " + id);
        }
    }

    public void updateEmployee(int id, Employee employee){
        try {
            jdbcTemplate.update("UPDATE employee set name=?, start=?, end=? WHERE id=?",
                    employee.getName(), employee.getStart(), employee.getEnd(), id);
        }catch (Exception exc){
            throw new DatabaseException("an exception happened in update " + id);
        }
    }
    public void deleteEmployeeById(int id){
        try {
            jdbcTemplate.update("delete from employee where id=?", id);
        }catch (Exception exc){
            throw new DatabaseException("an exception happened in deleteEmployeeById " + id);
        }
    }


    }

