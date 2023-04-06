package com.ws.vacation_project.service;

import com.ws.vacation_project.exception.DatabaseException;
import com.ws.vacation_project.exception.EmployeeNotFoundException;
import com.ws.vacation_project.model.Employee;
import com.ws.vacation_project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){

        return  employeeRepository.saveEmployee(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployees();
    }

    public Employee updateEmployee(int id, Employee employee) {
        Employee fetchedEmployee = getEmpById(id);
        if (fetchedEmployee == null) {
            throw new EmployeeNotFoundException("the employee does not exists " + id);
        }
        employeeRepository.updateEmployee(id, employee);

        return employee;
    }

    public Employee getEmpById(int id) {
        try {
            return employeeRepository.getEmployeeById(id);
        } catch (DatabaseException exc) {
            return null;
        }
    }
    public void deleteEmployee(int id) {
        Employee fetchedEmployee = getEmpById(id);
        if (fetchedEmployee == null) {
            throw new EmployeeNotFoundException("the employee does not exists " + id);
        }
        employeeRepository.deleteEmployeeById(id);
    }
}
