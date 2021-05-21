package com.example.demoEmployee.controller;

import com.example.demoEmployee.model.Employee;
import com.example.demoEmployee.repository.EmployeeRepository;
import com.example.demoEmployee.service.EmployeeJdbcService;
import com.example.demoEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping(path ="/employee")
public class EmployeeRestController {

    /**
     * Uncomment if you want to use mock DB
     */
//    @Autowired
//    private EmployeeService employeeService;

    @Autowired
    private EmployeeJdbcService employeeService;

    @GetMapping(path = "/employees/{id}", headers = {"Accept=application/json, application/xml","Content-Type=application/json, application/xml"})
    public Employee getEmployee(@PathVariable("id") long id){

        return employeeService.findEmployee(id);
    }

    @PostMapping(path = "/employees", headers = {"Accept=application/json, application/xml","Content-Type=application/json, application/xml"})
    public Employee createEmployee(@RequestBody Employee employee){

        return employeeService.addEmployee(employee);
    }

    @PutMapping(path = "/employees/{id}", headers = {"Accept=application/json, application/xml","Content-Type=application/json, application/xml"})
    public void updateSalary(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping(path = "/employees", headers = {"Accept=application/json, application/xml","Content-Type=application/json, application/xml"})
    public void removeEmployee(@RequestParam("id") long id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping(path = "/employees", headers = {"Accept=application/json, application/xml","Content-Type=application/json, application/xml"})
    public List<Employee> getAllEmployees(){

        return employeeService.allEmployees();

    }
}
