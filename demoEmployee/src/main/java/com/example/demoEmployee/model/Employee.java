package com.example.demoEmployee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private long id;
    private String name;
    private String dept;
    private double salary;
}
