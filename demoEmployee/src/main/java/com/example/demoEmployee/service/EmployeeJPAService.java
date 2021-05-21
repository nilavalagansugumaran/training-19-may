package com.example.demoEmployee.service;

import com.example.demoEmployee.model.Employee;
import com.example.demoEmployee.model.EmployeeJPA;
import com.example.demoEmployee.repository.EmployeeJPARepository;
import com.example.demoEmployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeJPAService {

    @Autowired
    private EmployeeJPARepository employeeJPARepository;

    public EmployeeJPA findEmployee(long id) {
        Optional<EmployeeJPA> data = employeeJPARepository.findById(id);
        if(data.isPresent()) {
            return data.get();
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EMPLOYEE NOT FOUND");
        }
    }

    public EmployeeJPA addEmployee(EmployeeJPA employee) {
        return employeeJPARepository.save(employee);
    }

    public void deleteEmployee(long id) {
        employeeJPARepository.deleteById(id);
    }

    public void updateEmployee(EmployeeJPA employee) {
        employeeJPARepository.save(employee);
    }

    public List<EmployeeJPA> allEmployees(){
        List<EmployeeJPA> employeeJPAList = new ArrayList<EmployeeJPA>();
        employeeJPARepository.findAll().forEach(e -> {
            employeeJPAList.add(e);
        });
        return employeeJPAList;
    }
}
