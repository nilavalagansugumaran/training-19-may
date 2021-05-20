package com.example.myprofilesdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
@Slf4j
public class MyBean2 implements MyBeanService{

    public void print(){
        log.info("MyBean2");
    }
}
