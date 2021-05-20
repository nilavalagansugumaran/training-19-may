package com.example.demoClient.controller;

import com.example.demoClient.service.CallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private CallerService callerService;

    @GetMapping(path = "/invokeEmployeeService")
    public String invoke(){

        callerService.callEmployeeService();
        return "successful, check logs";
    }
}
