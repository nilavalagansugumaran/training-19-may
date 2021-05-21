package com.example.demoEmployee.service;

import com.example.demoEmployee.model.Employee;
import com.example.demoEmployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeJdbcService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findEmployee(long id) {
        Employee employee = employeeRepository.getEmployee(id);
        if(employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not found");
        }
        return employee;
    }

    public Employee addEmployee(Employee employee) {
       return employeeRepository.addEmployee(employee);
    }

    public void deleteEmployee(long id) {
        employeeRepository.deleteEmployee(id);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    public List<Employee> allEmployees(){
        return employeeRepository.getALL();
    }
}
