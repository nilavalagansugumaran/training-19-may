package com.example.myprofilesdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
@Slf4j
public class MyBean1 implements MyBeanService{

    @Value("${contact.name}")
    private String name;

    public void print(){

        log.info("MyBean1, name {}", name);
    }
}
