package com.example.demoValidation.controller;

import com.example.demoValidation.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrdersControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void test_create_order_fail_un_authorised(){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Authorization", "Basic bmlsYTpwYXNzd29yZA==");
        HttpEntity entity = new HttpEntity("{\n" +
                "    \"name\": \"nila 20\",\n" +
                "    \"salary\": 4000.0\n" +
                "}", headers);

        ResponseEntity<Order> postResponse = testRestTemplate.exchange("/orders", HttpMethod.POST, entity, Order.class );
        assertTrue(postResponse.getStatusCode() == HttpStatus.FORBIDDEN);

    }

    @Test
    void test_create_order_success_with_auth(){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Authorization", "Basic YWRtaW46YWRtaW4=");
        HttpEntity entity = new HttpEntity("{\n" +
                "    \"items\": \"a,b,c\",\n" +
                "    \"price\": 300.0,\n" +
                "    \"phone\": \"0123456789\"\n" +
                "}", headers);

        ResponseEntity<Order> postResponse = testRestTemplate.exchange("/orders", HttpMethod.POST, entity, Order.class );
        assertTrue(postResponse.getStatusCode() == HttpStatus.OK);

    }

    @Test
    void test_create_order_fail_when_no_phone(){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Authorization", "Basic YWRtaW46YWRtaW4=");
        HttpEntity entity = new HttpEntity("{\n" +
                "    \"items\": \"a,b,c\",\n" +
                "    \"price\": 300.0,\n" +
                "    \"phone\": \"12345678\"\n" +
                "}", headers);

        ResponseEntity<Order> postResponse = testRestTemplate.exchange("/orders", HttpMethod.POST, entity, Order.class );
        assertTrue(postResponse.getStatusCode() == HttpStatus.BAD_REQUEST);

    }
}