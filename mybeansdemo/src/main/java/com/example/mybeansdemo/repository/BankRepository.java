package com.example.mybeansdemo.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class BankRepository {

    public void saveTransaction(Double amount){

        log.info("Saving transaction TO db... amount {}", amount );
    }
}
