package com.example.demoEmployee.model;

import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@XmlRootElement
public class Employee {

    private long id;
    private String name;
    private String dept;
    private double salary;
}
