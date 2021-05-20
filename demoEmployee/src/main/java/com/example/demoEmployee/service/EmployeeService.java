package com.example.demoEmployee.service;

import com.example.demoEmployee.model.Employee;
import com.example.demoEmployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    private static Map<Long, Employee> employeeMockDB = new HashMap();

    public Employee findEmployee(long id) {
//        Employee employee = employeeMockDB.get(id);
//        if(employee == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not found");
//        }
//        return employee;

        Employee employee = employeeRepository.getEmployee(id);
        if(employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee Not found");
        }
        return employee;
    }

    public Employee addEmployee(Employee employee) {
        employeeMockDB.put(employee.getId(), employee);
        return employee;
    }

    public void deleteEmployee(long id) {
        Employee employee = findEmployee(id);
        employeeMockDB.remove(id);
    }

    public void updateEmployee(Employee employee) {
        findEmployee(employee.getId());
        employeeMockDB.put(employee.getId(), employee);
    }

    public List<Employee> allEmployees(){
        return employeeMockDB.values().stream().collect(Collectors.toList());
    }

    @PostConstruct
    public void setup(){
        employeeMockDB.put(1l, Employee.builder().id(1l).name("nila 1").salary(200.00).dept("it").build());
        employeeMockDB.put(2l, Employee.builder().id(2l).name("nila 2").salary(300.00).dept("it").build());
        employeeMockDB.put(3l, Employee.builder().id(3l).name("nila 3").salary(400.00).dept("it").build());
    }

}
