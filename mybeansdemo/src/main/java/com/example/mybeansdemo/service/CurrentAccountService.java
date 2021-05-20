package com.example.mybeansdemo.service;


import com.example.mybeansdemo.repository.BankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CurrentAccountService implements BankAccountsService {

    @Autowired
    private BankRepository repository;

    @Override
    public void deposit(Double amount) {
        log.info("Current Account Deposit received {}", amount);
        repository.saveTransaction(amount + (amount*0.01));
    }
}
