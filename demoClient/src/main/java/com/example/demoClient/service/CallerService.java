package com.example.demoClient.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class CallerService {

    private RestTemplate restTemplate;

    @Value("${serviceBaseURl}")
    private String serviceBaseURl;

    public void callEmployeeService(){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/xml");
        headers.add("Accept", "application/xml");
        HttpEntity entity = new HttpEntity("", headers);

        ResponseEntity<String> response = restTemplate.exchange(serviceBaseURl, HttpMethod.GET, entity, String.class );
        log.info("get status = {} ", response.getStatusCode());
        log.info("get response = {} ", response.getBody());

        HttpEntity postEntity = new HttpEntity("<Employee>\n" +
                "    <id>100</id>\n" +
                "    <name>nila 100</name>\n" +
                "    <dept>it</dept>\n" +
                "    <salary>20000.0</salary>\n" +
                "</Employee>", headers);

        ResponseEntity<String> postResponse = restTemplate.exchange(serviceBaseURl, HttpMethod.POST, postEntity, String.class );
        log.info("POST status = {} ", postResponse.getStatusCode());
        log.info("pOST response = {} ", postResponse.getBody());

        response = restTemplate.exchange(serviceBaseURl+"/100", HttpMethod.GET, entity, String.class );
        log.info("get status = {} ", response.getStatusCode());
        log.info("get response = {} ", response.getBody());

    }

    @PostConstruct
    public void setup(){
        restTemplate = new RestTemplate();
    }
}
