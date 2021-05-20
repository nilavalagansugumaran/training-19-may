package com.example.myprofilesdemo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    @ConditionalOnProperty(name = "enable.bean1", havingValue = "true")
    public MyBeanService conditionalBean1(){
        return new MyBean1();
    }


    @Bean
    @ConditionalOnProperty(name = "enable.bean2", havingValue = "true")
    public MyBeanService conditionalBean2(){
        return new MyBean2();
    }
}
