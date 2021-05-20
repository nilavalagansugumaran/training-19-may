package com.example.demoEmployee.controller;

import com.example.demoEmployee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping(path ="/employee")
public class EmployeeRestController {

    @GetMapping(path = "/employees/{id}", headers = {"Accept=application/json, application/xml","Content-Type=application/json, application/xml"})
    public Employee getEmployee(@PathVariable("id") long id){

        return Employee.builder().id(1l).name("nila").salary(200.00).dept("it").build();
    }

    @PostMapping(path = "/employees", headers = {"Accept=application/json, application/xml","Content-Type=application/json, application/xml"})
    public Employee createEmployee(@RequestBody Employee employee){

        return Employee.builder().id(1l).name("nila").salary(200.00).dept("it").build();
    }

    @PutMapping(path = "/employees/{id}", headers = {"Accept=application/json, application/xml","Content-Type=application/json, application/xml"})
    public void updateSalary(@RequestBody Employee employee){

    }

    @DeleteMapping(path = "/employees", headers = {"Accept=application/json, application/xml","Content-Type=application/json, application/xml"})
    public void removeEmployee(@RequestParam("id") long id){

    }

    @GetMapping(path = "/employees", headers = {"Accept=application/json, application/xml","Content-Type=application/json, application/xml"})
    public List<Employee> getAllEmployees(){

        return Arrays.asList(Employee.builder().id(1l).name("nila").salary(200.00).dept("it").build());

    }
}
