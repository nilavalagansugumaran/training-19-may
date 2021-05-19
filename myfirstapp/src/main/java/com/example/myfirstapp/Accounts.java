package com.example.myfirstapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Accounts {

    //data
    private String name;

    public Accounts(@Value("${name}") String name) {
        this.name = name;
    }

    //behaviours
    public void sayHello(){
        System.out.println("Hello " + this.name);
        System.out.println(this.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
