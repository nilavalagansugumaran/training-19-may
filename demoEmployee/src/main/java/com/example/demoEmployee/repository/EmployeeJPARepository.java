package com.example.demoEmployee.repository;

import com.example.demoEmployee.model.EmployeeJPA;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJPARepository extends CrudRepository<EmployeeJPA, Long> {

    EmployeeJPA findEmployeeJPAByNameAndSalaryGreaterThan(String name, double salary);
}
