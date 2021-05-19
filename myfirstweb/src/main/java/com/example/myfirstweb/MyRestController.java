package com.example.myfirstweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @GetMapping(path = "/sayHello")
    public String sayHello(@RequestParam(name = "name", required = false, defaultValue = "nila") String name){

        return "Hello " + name;
    }
}
