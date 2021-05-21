package com.example.demoValidation.service;

import com.example.demoValidation.model.Order;
import com.example.demoValidation.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderRepository repository;

    @Test
    void expect_error_when_order_not_found(){

        //PROVIDED
      //  Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.empty());
        Mockito.when(repository.findById(Mockito.any())).thenThrow(new RecoverableDataAccessException("DB DOWN"));

        assertThrows(ResponseStatusException.class, ()->{
            orderService.getOrder(101);
        });

        Mockito.verify(repository, Mockito.times(1)).findById(Mockito.any());
    }

    @Test
    void expect_order_when_exists(){
        //PROVIDED
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(new Order()));

        // WHEN
        Order order = orderService.getOrder(101);

        //THEN
        assertNotNull(order);
        Mockito.verify(repository, Mockito.times(1)).findById(Mockito.any());
    }
}