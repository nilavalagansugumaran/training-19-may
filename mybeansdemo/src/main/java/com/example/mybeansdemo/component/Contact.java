package com.example.mybeansdemo.component;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Data
@ConfigurationProperties(prefix = "contact")
public class Contact {

    private String name;

    private Address address;

    @Data
    public static class Address {

        private String postcode;
    }
}
