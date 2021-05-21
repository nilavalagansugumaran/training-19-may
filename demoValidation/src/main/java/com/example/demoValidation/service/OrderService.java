package com.example.demoValidation.service;

import com.example.demoValidation.model.Order;
import com.example.demoValidation.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order getOrder(long id){
       Optional<Order> order = repository.findById(id);
       if(order.isPresent()) {
           return order.get();
       }
       throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ORDER OT FOUND");
    }

    public Order createOrder(Order request){
       return repository.save(request);
    }

}
