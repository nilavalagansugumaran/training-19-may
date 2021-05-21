package com.example.demoEmployee.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EmployeeJPA")
public class EmployeeJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "something")
    private Double salary;
}
