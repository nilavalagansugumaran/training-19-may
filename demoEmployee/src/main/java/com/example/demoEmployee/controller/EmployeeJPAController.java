package com.example.demoEmployee.controller;

import com.example.demoEmployee.model.Employee;
import com.example.demoEmployee.model.EmployeeJPA;
import com.example.demoEmployee.service.EmployeeJPAService;
import com.example.demoEmployee.service.EmployeeJdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping(path ="/employee")
public class EmployeeJPAController {

    @Autowired
    private EmployeeJPAService employeeService;

    @GetMapping(path = "/employeesJpa/{id}", headers = {"Accept=application/json, application/xml","Content-Type=application/json, application/xml"})
    public EmployeeJPA getEmployee(@PathVariable("id") long id){

        return employeeService.findEmployee(id);
    }

    @PostMapping(path = "/employeesJpa", headers = {"Accept=application/json, application/xml","Content-Type=application/json, application/xml"})
    public EmployeeJPA createEmployee(@RequestBody EmployeeJPA employee){

        return employeeService.addEmployee(employee);
    }

    @PutMapping(path = "/employeesJpa/{id}", headers = {"Accept=application/json, application/xml","Content-Type=application/json, application/xml"})
    public void updateSalary(@RequestBody EmployeeJPA employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping(path = "/employeesJpa", headers = {"Accept=application/json, application/xml","Content-Type=application/json, application/xml"})
    public void removeEmployee(@RequestParam("id") long id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping(path = "/employeesJpa", headers = {"Accept=application/json, application/xml","Content-Type=application/json, application/xml"})
    public List<EmployeeJPA> getAllEmployees(){

        return employeeService.allEmployees();

    }
}
