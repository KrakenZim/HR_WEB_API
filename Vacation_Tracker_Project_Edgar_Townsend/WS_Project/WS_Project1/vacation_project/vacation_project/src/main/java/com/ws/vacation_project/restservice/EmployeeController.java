package com.ws.vacation_project.restservice;


import com.ws.vacation_project.exception.EmployeeNotFoundException;
import com.ws.vacation_project.model.Employee;
import com.ws.vacation_project.repository.EmployeeRepository;
import com.ws.vacation_project.service.EmployeeService;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin(maxAge = 45000)
@RestController
@RequestMapping("/emp")


public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable int id){
        return new ResponseEntity<>(employeeService.getEmpById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        try {
            return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
        } catch (EmployeeNotFoundException exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity deleteEmployee(@PathVariable int id) {
        try {
            employeeService.deleteEmployee(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (EmployeeNotFoundException exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
